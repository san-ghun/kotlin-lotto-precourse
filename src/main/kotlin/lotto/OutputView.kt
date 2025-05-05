package lotto

import java.util.Locale

object OutputView {

    fun showTickets(lottoBundle: List<Lotto>) {
        lottoBundle.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun showStatistics(lottoMachine: LottoMachine) {
        val ranks = Rank.entries
        val winnerBoard = lottoMachine.winnerBoard
        println("\nWinning Statistics")
        println("---")
        println("${ranks[4].matchCount} Matches (${String.format(Locale.US, "%,d", ranks[4].prize)} KRW) – ${winnerBoard[ranks[4]]} tickets")
        println("${ranks[3].matchCount} Matches (${String.format(Locale.US, "%,d", ranks[3].prize)} KRW) – ${winnerBoard[ranks[3]]} tickets")
        println("${ranks[2].matchCount} Matches (${String.format(Locale.US, "%,d", ranks[2].prize)} KRW) – ${winnerBoard[ranks[2]]} tickets")
        println("${ranks[1].matchCount} Matches + Bonus Ball (${String.format(Locale.US, "%,d", ranks[1].prize)} KRW) – ${winnerBoard[ranks[1]]} tickets")
        println("${ranks[0].matchCount} Matches (${String.format(Locale.US, "%,d", ranks[0].prize)} KRW) – ${winnerBoard[ranks[0]]} tickets")
        println("Total return rate is ${lottoMachine.calculateReturnRate()}%.")
    }
}