package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
    }
}