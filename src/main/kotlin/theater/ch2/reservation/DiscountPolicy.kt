package theater.ch2.reservation

import theater.ch2.reservation.discount.DiscountCondition

abstract class DiscountPolicy(
    private val conditions: List<DiscountCondition>
) {

    fun calculateDiscountAmount(screening: Screening): Money = conditions
        .firstOrNull { it.isSatisfiedBy(screening) }
        ?.let { getDiscountAmount(screening) }
        ?: Money.empty()

    protected abstract fun getDiscountAmount(screening: Screening): Money

}
