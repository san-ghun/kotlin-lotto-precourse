package lotto.view

import camp.nextstep.edu.missionutils.Console
import net.bytebuddy.pool.TypePool.Resolution.Illegal

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return Console.readLine()
            .trim()
            .toIntOrNull()?.takeIf { it > 0 && it % 1000 == 0}
            ?: throw IllegalArgumentException("[ERROR] Input must be a positive number divisible by 1000.")
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return Console.readLine()
            .split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input.") }
            .also {
                require(it.size == 6) { "[ERROR] Must provide 6 numbers."}
                require(it.distinct().size == 6) { "[ERROR] Numbers must not be duplicated."}
                require(it.all { n -> n in 1..45 }) { "[ERROR] All numbers must be in between 1 and 45."}
            }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        return Console.readLine()
            .trim().toIntOrNull()
            ?.also {
                require(!winningNumbers.contains(it)) { "[ERROR] Bonus number must not a duplicated from the winning numbers." }
                require(it in 1..45) { "[ERROR] Bonus number must be in between 1 and 45." }
            }
            ?: throw IllegalArgumentException("[ERROR] Invalid input.")
    }
}