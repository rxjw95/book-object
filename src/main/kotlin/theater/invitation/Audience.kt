package theater.invitation

class Audience(
    private val bag: Bag
) {
    fun buy(ticket: Ticket): Long {
        return bag.putIn(ticket)
    }
}

class Bag(
    private var amount: Long,
    private val invitation: Invitation? = null
) {
    private var ticket: Ticket? = null

    fun putIn(ticket: Ticket): Long {
        if(hasInvitation()) {
            this.ticket = ticket
        } else {
            minusAmount(ticket.fee)
            this.ticket = ticket
        }
        return ticket.fee
    }

    fun hasInvitation(): Boolean = invitation != null

    fun hasTicket(): Boolean = ticket != null

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun minusAmount(amount: Long) {
        if(this.amount.minus(amount) < 0)
            throw Exception("금액이 부족합니다.")
        else
            this.amount -= amount
    }
}
