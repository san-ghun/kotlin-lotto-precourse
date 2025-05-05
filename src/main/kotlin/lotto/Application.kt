package lotto

import javax.accessibility.AccessibleBundle

fun main() {
    val lottoBundle = takeLottoTickets()
    issueLottoTickets(lottoBundle)

    val winningNumbers = takeWinningNumber()
    val winningTicket = Lotto(winningNumbers)
    val bonusNumber = takeBonusNumber(winningNumbers)

    val machine = LottoMachine(lottoBundle, winningTicket, bonusNumber)
    OutputView.showStatistics(machine)
}

private fun takeLottoTickets(): List<Lotto> {
    println("Please enter the purchase amount.")
    val purchasingAmount = reprompt { InputView.readPurchaseAmount() }
    val lottoBundle = LottoMachine.purchaseTickets(purchasingAmount)
    return lottoBundle
}

private fun issueLottoTickets(lottoBundle: List<Lotto>) {
    println("\nYou have purchased ${lottoBundle.size} tickets.")
    OutputView.showTickets(lottoBundle)
}

private fun takeWinningNumber(): List<Int> {
    println("\nPlease enter the bonus number.")
    val winningNumbers = reprompt { InputView.readWinningNumbers() }
    return winningNumbers
}

private fun takeBonusNumber(winningNumbers: List<Int>): Int {
    println("\nPlease enter the bonus number.")
    val bonusNumber = reprompt { InputView.readBonusNumber(winningNumbers) }
    return bonusNumber
}

private fun <T> reprompt(method: () -> T): T {
    while (true) {
        try {
            return method()
        } catch (error: IllegalArgumentException) {
            println(error.message)
        }
    }
}
