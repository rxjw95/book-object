package theater

class Theater(
    val ticketSeller: TicketSeller
) {
    fun enter(audience: Audience) = ticketSeller.sellTo(audience)
}