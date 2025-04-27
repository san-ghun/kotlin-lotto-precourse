package lotto.util

import camp.nextstep.edu.missionutils.Randoms

interface LottoGenerator {
    fun generateNumbers(): List<Int>
}

object RandomLottoGenerator: LottoGenerator {
    override fun generateNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }
}