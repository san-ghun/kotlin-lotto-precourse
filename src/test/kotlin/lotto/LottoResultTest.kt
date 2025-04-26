package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `initialize 'winningBoard' property with map in key 'Rank' value 0`() {
        val result = LottoResult()

        assertTrue(result.winningBoard.values.all { it == 0 })
    }

    @Test
    fun `add() - increase the 'Rank' value 1 when 'add()' called`() {
        val result = LottoResult()
        val rank = Rank.FIRST

        result.add(rank)
        assertEquals(1, result.winningBoard[rank])
    }

    @Test
    fun `add() - accumulate the 'Rank' value when 'add()' called multiple times`() {
        val result = LottoResult()
        val rank = Rank.SECOND

        repeat(3) { result.add(rank) }
        assertEquals(3, result.winningBoard[rank])
    }
}