package lotto.ui

import lotto.LottoBundle
import lotto.LottoResult
import lotto.Rank

object OutputView {
    fun printPurchasedLotto(bundle: LottoBundle) {
        val tickets = bundle.tickets
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers().toString())
        }
    }

    fun printStatistics(result: LottoResult) {
        println("\nWinning Statistics")
        println("---")
        println(result.report(Rank.entries[4]))
        println(result.report(Rank.entries[3]))
        println(result.report(Rank.entries[2]))
        println(result.report(Rank.entries[1]))
        println(result.report(Rank.entries[0]))
    }

    fun printProfitRate(result: LottoResult, amount: Int) {
        println("Total return rate is ${LottoResult.formatOutput("%,.1f", result.calculateProfit() / amount * 100)}%.")
    }
}