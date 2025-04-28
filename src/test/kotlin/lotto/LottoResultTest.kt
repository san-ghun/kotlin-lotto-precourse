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

    @Test
    fun `report() - return dedicated messages for each Rank without bonus matching`() {
        val result = LottoResult()
        val rank = Rank.THIRD

        val expected: (Int) -> String = { "5 Matches (1,500,000 KRW) – $it tickets" }
        var repeatCount = 0

        repeat(repeatCount) { result.add(rank) }
        assertEquals(expected(repeatCount), result.report(rank))

        repeatCount += 3

        repeat(repeatCount) { result.add(rank) }
        assertEquals(expected(repeatCount), result.report(rank))
    }

    @Test
    fun `report() - return dedicated message for a Rank with bonus matching`() {
        val result = LottoResult()
        val rank = Rank.SECOND

        val expected: (Int) -> String = { "5 Matches + Bonus Ball (30,000,000 KRW) – $it tickets" }
        var repeatCount = 0

        repeat(repeatCount) { result.add(rank) }
        assertEquals(expected(repeatCount), result.report(rank))

        repeatCount += 3

        repeat(repeatCount) { result.add(rank) }
        assertEquals(expected(repeatCount), result.report(rank))
    }

    @Test
    fun `calculateProfit() - return total profit from lotto result`() {
        val result = LottoResult()
        val rank = Rank.FOURTH

        var expected: Double
        var repeatCount = 0

        expected = 0.0
        repeat(repeatCount) { result.add(rank) }
        assertEquals(expected, result.calculateProfit())

        repeatCount += 3
        expected = 150_000.0
        repeat(repeatCount) { result.add(rank) }
        assertEquals(expected, result.calculateProfit())
    }
}