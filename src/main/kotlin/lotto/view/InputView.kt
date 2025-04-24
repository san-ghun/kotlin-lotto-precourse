package lotto.view

import camp.nextstep.edu.missionutils.Console
import net.bytebuddy.pool.TypePool.Resolution.Illegal

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val amount = Console.readLine()
            .trim()
        // Check non-numeric
            .toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        // Check zero
        // Check negative
        // Check less than 1000
        // Check divisible by 1000

        return amount
    }
}