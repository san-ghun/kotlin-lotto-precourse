package lotto.ui

import lotto.LottoBundle

object OutputView {
    fun printPurchasedLotto(bundle: LottoBundle) {
        println("You have purchased ${bundle.tickets.size} tickets.")
        bundle.tickets.forEach { ticket ->
            println(ticket.getNumbers().toString())
        }
    }
}