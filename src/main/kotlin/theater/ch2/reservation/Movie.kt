package theater.ch2.reservation

import kotlin.time.Duration

class Movie(
    private val name: String,
    private val fee: Money,
    private val runningTime: Duration,
    private val discountPolicy: DiscountPolicy
) {
    fun calculateMovieFee(screening: Screening): Money = fee.minus(discountPolicy.calculateDiscountAmount(screening))
}