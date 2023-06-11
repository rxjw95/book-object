package theater.ch2.reservation.discount

import theater.ch2.reservation.Screening

interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean

}
