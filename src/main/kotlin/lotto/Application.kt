package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    // 1. Input Purchase Amount
    val amount: Int = InputView.readPurchaseAmount()

    // 2. Issue Lottery Tickets
    val machine = LottoMachine()
    val lottoBundle: List<Lotto> = machine.issueBundle(amount)
    OutputView.printPurchasedLotto(lottoBundle)

    // 3. Input Winning Numbers
    val winningNumbers: List<Int> = InputView.readWinningNumbers()
    val bonusNumber: Int = InputView.readBonusNumber(winningNumbers)

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    // 4. Calculate Winning Matches
    val result = LottoResult()
    lottoBundle.forEach { lotto ->
        val rank = winningLotto.match(lotto)
        result.add(rank)
    }

    // 5. Output Statistics and Return Rate
    OutputView.printStatistics(result)
    OutputView.printProfitRate(result, amount)
}
