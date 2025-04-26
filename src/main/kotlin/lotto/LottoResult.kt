package lotto

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
}