package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int {
        val userInput = Console.readLine().trim()
        require(userInput.isNotBlank()) { "[ERROR] Invalid input - is blank, read purchase amount" }
        val amount = userInput.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input - is not int, read purchase amount")
        require(amount % 1_000 == 0) { "[ERROR] Invalid input - indivisible by 1,000, read purchase amount" }
        return amount
    }
}