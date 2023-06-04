package theater

class Audience(
    val bag: Bag
) {
    fun buy(ticket: Ticket): Long {
        if(bag.hasInvitation()) {
            bag.ticket = ticket
        } else {
            bag.minusAmount(ticket.fee)
            bag.ticket = ticket
        }
        return ticket.fee
    }
}

class Bag(
    var amount: Long,
    val invitation: Invitation? = null
) {
    var ticket: Ticket? = null

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
