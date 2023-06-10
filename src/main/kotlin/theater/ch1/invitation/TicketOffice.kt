package theater.ch1.invitation

class TicketOffice(
    var amount: Long,
    var tickets: MutableList<Ticket>
) {

    fun issue(): Ticket = tickets.removeFirstOrNull() ?: throw NullPointerException("티켓이 모두 소진되었습니다.")

    fun cancel(ticket: Ticket) = tickets.add(ticket)

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}
