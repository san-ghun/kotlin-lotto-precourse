package lotto

private const val PRICE_PER_TICKET = 1_000

class LottoMachine(private val generator: LottoGenerator = TODO("RandomLottoGenerator")) {
    fun issueBundle(amount: Int): LottoBundle {
        // Calculate number of ticket based on purchase amount
        val count = amount / PRICE_PER_TICKET
        // Generate tickets in LottoTicket
        val tickets = List(count) { Lotto(generator.generateNumbers()) }
            // Each lotto contains 6 unique random numbers between 1-45
            // Numbers are sorted in ascending order
        return LottoBundle(tickets)
    }
}