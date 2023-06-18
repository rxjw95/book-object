package theater.ch2.reservation

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

data class Money private constructor(
    private val value: BigDecimal
) {

    fun plus(money: Money): Money = Money(value.plus(money.value))
    fun minus(money: Money): Money {
        if (value < money.value) {
            throw RuntimeException("가지고 있는 금액보다 큰 금액을 뺄 수 없습니다.")
        }
        return Money(value.minus(money.value))
    }

    fun times(percent: Double): Money = Money(
        value
            .times(BigDecimal(percent))
            .setScale(0, RoundingMode.HALF_UP)
    )

    fun isLessThan(money: Money) = value < money.value
    fun isGreaterThan(money: Money) = value >= money.value

    init {
        if (value < BigDecimal.ZERO) {
            throw RuntimeException("돈은 음수일 수 없습니다.")
        }
    }

    companion object {
        fun wons(positive: Int) = Money(BigDecimal(positive))
        fun empty() = Money(BigDecimal(0))
    }
}
