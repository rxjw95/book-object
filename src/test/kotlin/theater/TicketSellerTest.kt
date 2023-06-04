package theater

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TicketSellerTest {

    @Test
    fun sellTo_Payment_Success() {
        val ticketOffice = TicketOffice(0, mutableListOf(Ticket(1000), Ticket(1000)))
        val audience = Audience(Bag(1000))

        val ticketSeller = TicketSeller(ticketOffice)
        assertDoesNotThrow {
            ticketSeller.sellTo(audience)
        }
    }

    @Test
    fun sellTo_Payment_Fail() {
        val ticketOffice = TicketOffice(0, mutableListOf(Ticket(1000), Ticket(1000)))
        val audience = Audience(Bag(500))

        val ticketSeller = TicketSeller(ticketOffice)

        assertThrows<Exception> {
            ticketSeller.sellTo(audience)
        }
        assertEquals(2, ticketOffice.tickets.size)
    }
}