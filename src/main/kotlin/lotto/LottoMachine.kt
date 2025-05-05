package lotto

class LottoMachine(
    private val lottoBundle: List<Lotto>,
    private val winningTicket: Lotto,
    private val bonusNumber: Int,
) {
    private val _winnerBoard = mutableMapOf<Rank, Int>()

    val winnerBoard: Map<Rank, Int>
        get() = _winnerBoard

    init {
        Rank.entries.forEach { _winnerBoard[it] = 0 }
        matchWinning()
    }

    private fun addWinning(rank: Rank) {
        _winnerBoard[rank] = _winnerBoard.getOrDefault(rank, 0) + 1
    }

    private fun matchWinning() {
        lottoBundle.forEach { ticket ->
            val matchCount = ticket.getNumbers().count { it in winningTicket.getNumbers() }
            val isMatchBonus = bonusNumber in ticket.getNumbers()
            addWinning(Rank.matchRank(matchCount, isMatchBonus))
        }
    }

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