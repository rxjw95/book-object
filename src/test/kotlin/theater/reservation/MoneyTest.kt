package theater.reservation

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertDoesNotThrow
import theater.ch2.reservation.Money
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MoneyTest {

    @Nested
    inner class Creation {

        @Test
        fun `wons 정적 메서드에 양수를 넣으면 성공`() {
            assertDoesNotThrow {
                Money.wons(1)
            }
        }

        @Test
        fun `wons 정적 메서드에 음수를 넣으면 RuntimeException`() {
            val message = assertFailsWith(
                exceptionClass = RuntimeException::class,
                block = {
                    Money.wons(-100)
                }
            ).message

            assertEquals("돈은 음수일 수 없습니다.", message)
        }

        @Test
        fun `empty 정적 메서드는 0원을 반환`() {
            val emptyMoney = Money.empty()
            assertEquals(Money.wons(0), emptyMoney)
        }
    }

    @Nested
    inner class Behavior {

        @Test
        fun `100원 더하기 100원은 200원`() {
            val money = Money.wons(100)
            val resultMoney = money.plus(Money.wons(100))
            assertEquals(Money.wons(200), resultMoney)
        }

        @Test
        fun `100원 빼기 100원은 0원`() {
            val money = Money.wons(100)
            val resultMoney = money.minus(Money.wons(100))
            assertEquals(Money.empty(), resultMoney)
        }

        @Test
        fun `100원 빼기 200원은 RuntimeException`() {
            val money = Money.wons(100)

            val assertFailsWith = assertFailsWith(
                exceptionClass = RuntimeException::class,
                block = {
                    money.minus(Money.wons(200))
                }
            )

            assertEquals("가지고 있는 금액보다 큰 금액을 뺄 수 없습니다.", assertFailsWith.message)
        }

        @Test
        fun `200원은 100원보다 크다`() {
            val resultBoolean = Money.wons(200).isGreaterThan(Money.wons(100))
            assertEquals(true, resultBoolean)
        }

        @Test
        fun `100원은 200원보다 작다`() {
            val resultBoolean = Money.wons(100).isLessThan(Money.wons(200))
            assertEquals(true, resultBoolean)
        }

        @Test
        fun `100원에 3을 곱하면 300원`() {
            val resultMoney = Money.wons(100).times(3.0)
            assertEquals(Money.wons(300), resultMoney)
        }
    }

}