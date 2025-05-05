package lotto

import camp.nextstep.edu.missionutils.Randoms

object RandomTicketGenerator {
    fun generateTicket(howManyNumbers: Int = 6): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, howManyNumbers)
        return numbers.sorted()
    }
}