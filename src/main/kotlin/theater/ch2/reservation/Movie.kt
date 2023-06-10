package theater.ch2.reservation

import kotlin.time.Duration

class Movie(
    private val name: String,
    private val fee: Int,
    private val runningTime: Duration
) {
    fun calculateMovieFee(audienceCount: Int): Money = Money.wons(fee * audienceCount)
}