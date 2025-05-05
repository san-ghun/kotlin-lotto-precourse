package lotto

object OutputView {

    fun showTickets(lottoBundle: List<Lotto>) {
        lottoBundle.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }
}