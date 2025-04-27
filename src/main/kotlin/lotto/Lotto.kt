package lotto

class Lotto(private val numbers: List<Int>) {
    private val lottoLength: Int = Config.LENGTH_OF_LOTTO
    private val minNumber: Int = Config.MIN_LOTTO_NUMBER
    private val maxNumber: Int = Config.MAX_LOTTO_NUMBER

    init {
        require(numbers.size == lottoLength) { "[ERROR] Lotto must contain exactly $lottoLength numbers." }
        require(numbers.distinct().size == lottoLength) { "[ERROR] Lotto numbers must be unique."}
        require(numbers.all { it in minNumber..maxNumber }) { "[ERROR] Lotto numbers must be between $minNumber and $maxNumber."}
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}
