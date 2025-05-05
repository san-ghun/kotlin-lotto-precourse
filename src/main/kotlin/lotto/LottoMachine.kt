package lotto

class LottoMachine(
    private val lottoBundle: List<Lotto>,
    private val winningTicket: Lotto,
    private val bonusNumber: Int,
) {
    companion object {
        fun purchaseTickets(amount: Int): List<Lotto> {
            val howManyTickets = amount / 1_000
            val tickets = List(howManyTickets) {
                Lotto(RandomTicketGenerator.generateTicket())
            }
            return tickets
        }
    }
}