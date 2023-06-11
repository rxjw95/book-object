package theater.ch2.reservation

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(
            customer,
            this,
            calculateFee(audienceCount),
            audienceCount
        )
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount)
    }
}
