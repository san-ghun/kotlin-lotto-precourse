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
}