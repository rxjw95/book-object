package theater.ch2.reservation

import org.junit.jupiter.api.Assertions.*
import theater.ch2.reservation.discount.AmountDiscountPolicy
import theater.ch2.reservation.discount.PercentageDiscountPolicy
import theater.ch2.reservation.discount.condition.SequenceCondition
import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.time.Duration

class DiscountPolicyTest {

    @Test
    fun `금액 할인 테스트`() {
        val condition = SequenceCondition(1)
        val policy = AmountDiscountPolicy(Money.wons(500), listOf(condition))

        val movie = Movie(
            "avatar",
            Money.wons(5_500),
            Duration.parse("P0DT1H30M"),
            policy)

        val screening = Screening(movie, 1, LocalDateTime.of(2023, 10, 8, 10, 0))

        val discountAmount = policy.calculateDiscountAmount(screening)

        assertEquals(discountAmount, Money.wons(500))
    }

    @Test
    fun `퍼센트 할인 테스트`() {
        val condition = SequenceCondition(1)
        val policy = PercentageDiscountPolicy(0.1, listOf(condition))

        val movie = Movie(
            "avatar",
            Money.wons(5_000),
            Duration.parse("P0DT1H30M"),
            policy)

        val screening = Screening(movie, 1, LocalDateTime.of(2023, 10, 8, 10, 0))

        val discountAmount = policy.calculateDiscountAmount(screening)

        assertEquals(discountAmount, Money.wons(500))


    }

}