package lotto

import camp.nextstep.edu.missionutils.Randoms

object RandomLottoGenerator: LottoGenerator {
    override fun generateNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }
}