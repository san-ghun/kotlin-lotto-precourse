package lotto.ui

import lotto.LottoBundle

object OutputView {
    fun printPurchasedLotto(bundle: LottoBundle) {
        val tickets = bundle.tickets
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers().toString())
        }
    }
}