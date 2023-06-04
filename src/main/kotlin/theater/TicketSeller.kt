package theater

class TicketSeller (
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        val ticket = ticketOffice.issue()
        try {
            val fee = audience.buy(ticket)
            ticketOffice.plusAmount(fee)
        } catch (e: Exception) {
            ticketOffice.cancel(ticket)
            throw Exception("판매할 수 없습니다.")
        }
    }
}