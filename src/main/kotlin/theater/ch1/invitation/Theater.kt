package theater.ch1.invitation

class Theater(
    val ticketSeller: TicketSeller
) {
    fun enter(audience: Audience) = ticketSeller.sellTo(audience)
}