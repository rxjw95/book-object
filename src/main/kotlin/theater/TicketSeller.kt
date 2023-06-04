package theater

class TicketSeller (
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        val ticket = ticketOffice.issue()
        val fee = audience.buy(ticket)
        ticketOffice.plusAmount(fee)
    }
}