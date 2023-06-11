package theater.ch2.reservation.discount.condition

import theater.ch2.reservation.Screening
import theater.ch2.reservation.discount.DiscountCondition
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

class SequenceCondition(
    private val sequence: Int
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean = screening.matchSequence(sequence)

}

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean =
                dayOfWeek == screening.getStartTime().dayOfWeek &&
                startTime <= screening.getStartTime().toLocalTime() &&
                screening.getStartTime().toLocalTime() <= endTime

}