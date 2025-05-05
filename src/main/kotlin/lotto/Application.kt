package lotto

fun main() {
    println("Please enter the purchase amount.")
    val purchasingAmount = reprompt { InputView.readPurchaseAmount() }
    val lottoBundle = LottoMachine.purchaseTickets(purchasingAmount)

    println("\nYou have purchased ${lottoBundle.size} tickets.")
    OutputView.showTickets(lottoBundle)

    println("\nPlease enter the bonus number.")
    val winningNumbers = reprompt { InputView.readWinningNumbers() }
    val winningTicket = Lotto(winningNumbers)

    println("\nPlease enter the bonus number.")
    val bonusNumber = reprompt { InputView.readBonusNumber(winningNumbers) }

    val machine = LottoMachine(lottoBundle, winningTicket, bonusNumber)

    OutputView.showStatistics(machine)
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
