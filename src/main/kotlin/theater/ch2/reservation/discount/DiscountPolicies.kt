package theater.ch2.reservation.discount

import theater.ch2.reservation.DiscountPolicy
import theater.ch2.reservation.Money
import theater.ch2.reservation.Screening

class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>
) : DiscountPolicy(conditions) {
    override fun getDiscountAmount(screening: Screening): Money = discountAmount
}

class PercentageDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>
) : DiscountPolicy(conditions) {
    override fun getDiscountAmount(screening: Screening): Money =
        screening.getMovieFee().times(percent)
}