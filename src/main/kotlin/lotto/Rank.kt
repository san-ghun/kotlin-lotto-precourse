package lotto

enum class Rank(
    val matchCount: Int,
    val mustMatchBonus: Boolean,
    val prize: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun matching(matchCount: Int, isMatchBonus: Boolean): Rank {
            return entries.find {
                it.matchCount == matchCount && (it.mustMatchBonus == isMatchBonus || it.matchCount < 5)
            } ?: NONE
        }
    }
}