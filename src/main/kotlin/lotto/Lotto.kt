package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto must consist of 6 unique numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be in the range from 1 to 45." }
    }

    fun getNumbers() = numbers.sorted()
}
