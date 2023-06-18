package theater.ch2.reservation.discount.condition

import theater.ch2.reservation.Money
import theater.ch2.reservation.Movie
import theater.ch2.reservation.Screening
import theater.ch2.reservation.discount.AmountDiscountPolicy
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.time.Duration

class PeriodConditionTest {

    @Test
    fun isSatisfiedBy() {
        val dateTime = LocalDateTime.of(2023, 1, 1, 10, 10)
        val condition = PeriodCondition(DayOfWeek.SUNDAY, LocalTime.of(9, 0), LocalTime.of(11, 0))
        val screening = Screening(
            Movie("avatar",
                Money.wons(1_000),
                Duration.parse("P0DT1H30M"),
                AmountDiscountPolicy(Money.wons(1_000), listOf(condition))
            ),
            3,
            dateTime)

        assertTrue {
            condition.isSatisfiedBy(screening)
        }
    }
}