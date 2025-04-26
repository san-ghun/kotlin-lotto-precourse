package lotto

import java.util.Locale

class LottoResult {
    private var _winningBoard: MutableMap<Rank, Int> = mutableMapOf()
    val winningBoard: Map<Rank, Int>
        get() = _winningBoard

    init {
        Rank.entries.forEach { _winningBoard[it] = 0 }
    }

    fun add(rank: Rank) {
        _winningBoard[rank] = _winningBoard.getOrDefault(rank, 0) + 1
    }

    fun report(rank: Rank): String {
        // TODO: NOT SURE I can `import java.util`
        if (rank.mustMatchBonus)
            return "${rank.matchCount} Matches + Bonus Ball (${String.format(Locale.US, "%,d", rank.prize)} KRW) - ${_winningBoard[rank]} tickets"
        return "${rank.matchCount} Matches (${String.format(Locale.US, "%,d", rank.prize)} KRW) - ${_winningBoard[rank]} tickets"
    }
}