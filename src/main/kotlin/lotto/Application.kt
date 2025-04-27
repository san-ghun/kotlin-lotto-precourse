package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amount = retryable { InputView.readPurchaseAmount() }

    val machine = LottoMachine()
    val lottoBundle = machine.issueBundle(amount)
    OutputView.printPurchasedLotto(lottoBundle)

    val winningNumbers = retryable { InputView.readWinningNumbers() }
    val bonusNumber = retryable { InputView.readBonusNumber(winningNumbers) }
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val result = LottoResult()
    lottoBundle.forEach { lotto ->
        val rank = winningLotto.match(lotto)
        result.add(rank)
    }

    OutputView.printStatistics(result)
    OutputView.printProfitRate(result, amount)
}

private fun <T> retryable(inputMethod: () -> T): T {
    while (true) {
        try {
            return inputMethod()
        } catch (err: IllegalArgumentException) {
            println("${err.message}")
        }
    }
}