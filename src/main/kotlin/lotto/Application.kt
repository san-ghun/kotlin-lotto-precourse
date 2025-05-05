package lotto

fun main() {
    println("Please enter the purchase amount.")
    val purchasingAmount = InputView.readPurchaseAmount()
    val lottoBundle = LottoMachine.purchaseTickets(purchasingAmount)

    println("\nYou have purchased ${lottoBundle.size} tickets.")
    OutputView.showTickets(lottoBundle)

    println("\nPlease enter the bonus number.")
    val winningTicket = InputView.readWinningNumbers()

    println("\nPlease enter the bonus number.")
    val bonusNumber = InputView.readBonusNumber()

    val machine = LottoMachine(lottoBundle, winningTicket, bonusNumber)

//    OutputView.showStatistics(machine)
    println("\nWinning Statistics")
    println("---")
    println("3 Matches (0,000 KRW) - 0 tickets")
    println("4 Matches (0,000 KRW) - 0 tickets")
    println("5 Matches (0,000 KRW) - 0 tickets")
    println("5 Matches + Bonus Ball (0,000 KRW) - 0 tickets")
    println("6 Matches (0,000 KRW) - 0 tickets")
    println("Total return rate is 00.0%.")
}
