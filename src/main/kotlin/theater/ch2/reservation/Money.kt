package theater.ch2.reservation

data class Money(
    private val value: Int
) {
    fun plus(money: Money): Money = Money(value.plus(money.value))
    fun minus(money: Money): Money {
        if(value < money.value) {
            throw RuntimeException("가지고 있는 금액보다 큰 금액을 뺄 수 없습니다.")
        }
        return Money(value.minus(money.value))
    }
    fun times(percent: Int): Money = Money(value.times(percent))

    fun isLessThan(money: Money) = value < money.value
    fun isGreaterThan(money: Money) = value >= money.value

    init {
        if(value < 0) {
            throw RuntimeException("돈은 음수일 수 없습니다.")
        }
    }

    companion object {
        fun wons(positive: Int) = Money(positive)
        fun empty() = Money(0)
    }
}
