package lotto

import lotto.util.LottoGenerator
import lotto.util.RandomLottoGenerator

class LottoMachine(private val generator: LottoGenerator = RandomLottoGenerator) {
    fun issueBundle(amount: Int): List<Lotto> {
        val pricePerTicket: Int = Config.PRICE_PER_TICKET

        require(amount >= pricePerTicket) { "[ERROR] Amount must be at least ${pricePerTicket}." }
        require(amount % pricePerTicket == 0) { "[ERROR] Amount must be divisible by ${pricePerTicket}." }

        val count = amount / pricePerTicket
        val bundle = List(count) { Lotto(generator.generateNumbers()) }
        return bundle
    }
}