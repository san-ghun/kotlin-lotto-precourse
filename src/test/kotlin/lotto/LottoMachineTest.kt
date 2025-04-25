package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `throws an exception when amount of currency is less than the price of a ticket`() {
        val testMachine = LottoMachine()
        val testCases = listOf(0, -5, 1, 2, 9, 10, 100, 523, 999)
        testCases.forEach { case ->
            assertThrows<IllegalArgumentException> {
                testMachine.issueBundle(case)
            }
        }
    }

    @Test
    fun `throws an exception when amount of currency is indivisible by the price of a ticket`() {
        val testMachine = LottoMachine()
        val testCases = listOf(1001, 1100, 1010, 1110, 1011, 4564, 9999, 1928376)
        testCases.forEach { case ->
            assertThrows<IllegalArgumentException> {
                testMachine.issueBundle(case)
            }
        }
    }
}