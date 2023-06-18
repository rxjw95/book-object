package theater.ch2.reservation

import org.junit.jupiter.api.Assertions.*
import theater.ch2.reservation.discount.AmountDiscountPolicy
import theater.ch2.reservation.discount.PercentageDiscountPolicy
import theater.ch2.reservation.discount.condition.PeriodCondition
import theater.ch2.reservation.discount.condition.SequenceCondition
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.Test
import kotlin.time.Duration

class ScreeningTest {

    @Test
    fun `고객 한 명이 첫 번째로 상영되는 8000원의 영화를 500원 금액 할인을 적용받아 7500원에 예매한다`() {

        val condition = SequenceCondition(1)
        val policy = AmountDiscountPolicy(Money.wons(500), listOf(condition))

        val movie =
            Movie("king kong", Money.wons(8_000), Duration.parseIsoString("PT1H30M"), policy)
        val screening = Screening(movie, 1, LocalDateTime.of(2023, 10, 8, 6, 30))

        val customer = Customer(1, "woogie")

        val reserve = screening.reserve(customer, 1)
        assertEquals(reserve.fee, Money.wons(7500))

    }

    @Test
    fun `고객 한 명이 첫 번째로 상영되는 8000원의 영화를 10퍼센트 할인을 적용받아 7200원에 예매한다`() {

        val condition = SequenceCondition(1)
        val policy = PercentageDiscountPolicy(0.1, listOf(condition))

        val movie =
            Movie("king kong", Money.wons(8_000), Duration.parseIsoString("PT1H30M"), policy)
        val screening = Screening(movie, 1, LocalDateTime.of(2023, 10, 8, 6, 30))

        val customer = Customer(1, "woogie")

        val reserve = screening.reserve(customer, 1)
        assertEquals(reserve.fee, Money.wons(7200))

    }

    @Test
    fun `고객 한명이 일요일 오후 1시에서 오후 3시 사이에 상영되는 8000원의 영화를 10퍼센트 할인을 적용받아 7200원에 예매한다`() {

        val condition = PeriodCondition(DayOfWeek.SUNDAY, LocalTime.of(13, 0), LocalTime.of(15, 0))
        val policy = PercentageDiscountPolicy(0.1, listOf(condition))

        val movie = Movie("king kong", Money.wons(8_000), Duration.parseIsoString("PT1H30M"), policy)
        val screening = Screening(movie, 1, LocalDateTime.of(2023, 10, 8, 13, 30))

        val customer = Customer(1, "woogie")

        val reserve = screening.reserve(customer, 1)
        assertEquals(reserve.fee, Money.wons(7200))

    }

    @Test
    fun `고객 한명이 일요일 오후 1시에서 오후 3시 사이에 상영되는 8000원의 영화를 500원 금액 할인을 받아 7500원에 예매한다`() {

        val condition = PeriodCondition(DayOfWeek.SUNDAY, LocalTime.of(13, 0), LocalTime.of(15, 0))
        val policy = AmountDiscountPolicy(Money.wons(500), listOf(condition))

        val movie = Movie("king kong", Money.wons(8_000), Duration.parseIsoString("PT1H30M"), policy)
        val screening = Screening(movie, 1, LocalDateTime.of(2023, 10, 8, 13, 30))

        val customer = Customer(1, "woogie")

        val reserve = screening.reserve(customer, 1)
        assertEquals(reserve.fee, Money.wons(7500))

    }

}