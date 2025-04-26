package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `throw an exception when bonus number is not in range 1 and 45 inclusive`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> {
            WinningLotto(numbers, 0)
        }

        assertThrows<IllegalArgumentException> {
            WinningLotto(numbers, 46)
        }
    }

    @Test
    fun `throw an exception when bonus number is a duplicate with a number in winning numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> {
            WinningLotto(numbers, 6)
        }
    }

    @Test
    fun `matchCount() - return count of matching numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(numbers, 7)

        val userLotto = Lotto(listOf(1, 2, 3, 10, 20, 30))
        assertEquals(3, winningLotto.matchCount(userLotto))
    }

    @Test
    fun `isMatchBonusNumber() - return true or false when bonus number match or not match within winning numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(numbers, 7)

        val userLottoTrue = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val userLottoFalse = Lotto(listOf(1, 2, 3, 10, 20, 30))

        assertTrue(winningLotto.isMatchBonusNumber(userLottoTrue))
        assertFalse(winningLotto.isMatchBonusNumber(userLottoFalse))
    }
}