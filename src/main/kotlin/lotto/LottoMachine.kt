package lotto

private const val PRICE_PER_TICKET = 1_000

class LottoMachine(private val generator: LottoGenerator = RandomLottoGenerator) {
    fun issueTicket(amount: Int): LottoTicket {
        // Calculate number of lottos based on purchase amount
        val count = amount / PRICE_PER_TICKET
        // Generate lottos in LottoTicket
        val tickets = List(count) { Lotto(generator.generateNumbers()) }
            // Each lotto contains 6 unique random numbers between 1-45
            // Numbers are sorted in ascending order
        return LottoTicket(tickets)
    }
}