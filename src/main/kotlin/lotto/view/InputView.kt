package lotto.view

import camp.nextstep.edu.missionutils.Console

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
        val userInput = Console.readLine()
            // Check comma-separated
            .split(",")
            // Check non-numeric
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.") }
            // Check empty, blank
            // Check for 6 numbers
            // Check numbers in range 1-45
            // Check duplicates
        return userInput
    }
}