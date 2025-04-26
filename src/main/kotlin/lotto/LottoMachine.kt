package lotto

import lotto.util.LottoGenerator
import lotto.util.RandomLottoGenerator

private const val PRICE_PER_TICKET = 1_000

class LottoMachine(private val generator: LottoGenerator = RandomLottoGenerator) {
    fun issueBundle(amount: Int): LottoBundle {
        require(amount >= PRICE_PER_TICKET) { "[ERROR] Amount must be at least ${PRICE_PER_TICKET}." }
        require(amount % PRICE_PER_TICKET == 0) { "[ERROR] Amount must be divisible by ${PRICE_PER_TICKET}." }

        val count = amount / PRICE_PER_TICKET
        val tickets = List(count) { Lotto(generator.generateNumbers()) }
        return LottoBundle(tickets)
    }
}