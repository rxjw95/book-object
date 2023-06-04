package theater

class TicketSeller (
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        if(audience.bag.hasInvitation()) {
            val ticket = ticketOffice.issue()
            audience.bag.ticket = ticket
        } else {
            val ticket = ticketOffice.issue()
            audience.bag.minusAmount(ticket.fee)
            ticketOffice.plusAmount(ticket.fee)
            audience.bag.ticket = ticket
        }
    }
}