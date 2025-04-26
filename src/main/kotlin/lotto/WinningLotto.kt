package lotto

class WinningLotto(
    private val numbers: List<Int>,
    private val bonusNumber: Int,
) {

    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be in between 1 and 45." }
        require(!numbers.contains(bonusNumber)) { "[ERROR] Bonus number must not a duplicated from the winning numbers." }
    }

    val ticket: Lotto
        get() = Lotto(numbers)

    fun matchCount(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in ticket.getNumbers() }
    }

    fun isMatchBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }

    fun match(lotto: Lotto): Rank {
        val matchCount = this.matchCount(lotto)
        val isMatchBonus = this.isMatchBonusNumber(lotto)
        return Rank.matching(matchCount, isMatchBonus)
    }
}