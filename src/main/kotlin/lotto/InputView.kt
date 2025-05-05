package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int {
        val userInput = Console.readLine().trim()
        require(userInput.isNotBlank()) { "[ERROR] Invalid input - is blank, read purchase amount" }
        val amount = userInput.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid input - is not int, read purchase amount")
        require(amount % 1_000 == 0) { "[ERROR] Invalid input - indivisible by 1,000, read purchase amount" }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        val userInput = Console.readLine().trim()
        require(userInput.isNotBlank()) { "[ERROR] Invalid input - is blank, read winning numbers" }
        val splitInput = userInput.split(",")
        require(splitInput.size == 6) { "[ERROR] Invalid input - there must be 6 numbers, read winning numbers" }
        val numbers = splitInput.map {
            it.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid input - there must be 6 numbers, read winning numbers")
        }
        require(numbers.distinct().size == 6) { "[ERROR] Invalid input - there must be 6 numbers, read winning numbers" }
        require(numbers.all { it in 1..45 }) { "[ERROR] Invalid input - numbers must be in the range from 1 to 45, read winning numbers" }
        return numbers.sorted()
    }

    fun readBonusNumber(): Int {
        val userInput = Console.readLine().trim()
        require(userInput.isNotBlank()) { "[ERROR] Invalid input - is blank, read bonus number" }
        val number = userInput.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid input - is not int, read bonus number")
        require(number in 1..45) { "[ERROR] Invalid input - numbers must be in the range from 1 to 45, read bonus number" }
        return number
    }
}