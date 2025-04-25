package lotto

import lotto.ui.InputView

fun main() {
    // 1. Input Purchase Amount
    val amount = InputView.readPurchaseAmount()

    // 2. Issue Lottery Tickets
    val machine = LottoMachine()
    val lottoTicket = machine.issueTicket(amount)
    //OutputView.printPurchasedLotto(lottoTicket)

    // 3. Input Winning Numbers
    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    //val winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)

    // 4. Calculate Winning Matches
    //val result = LottoResult()
    //lottoTicket.getTickets().forEach { lotto ->
    //    val rank = winningLotto.match(lotto)
    //    result.add(rank)
    //}

    // 5. Output Statistics and Return Rate
    //OutputView.printStatistics(result)
    //OutputView.printReturnRate(result, amount)
}
