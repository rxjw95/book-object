package theater

class Audience(
    val bag: Bag
)

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
        this.amount -= amount
    }
}
