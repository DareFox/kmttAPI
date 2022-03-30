package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param propertyEntries
 * @param comments
 * @param favorites
 * @param events
 * @param vacancies
 * @param subscribers
 * @param subscriptions
 * @param votes
 */

data class SubsiteCounters(

    @JsonNames("entries")
    val propertyEntries: java.math.BigDecimal? = null,

    @JsonNames("comments")
    val comments: java.math.BigDecimal? = null,

    @JsonNames("favorites")
    val favorites: java.math.BigDecimal? = null,

    @JsonNames("events")
    val events: java.math.BigDecimal? = null,

    @JsonNames("vacancies")
    val vacancies: java.math.BigDecimal? = null,

    @JsonNames("subscribers")
    val subscribers: java.math.BigDecimal? = null,

    @JsonNames("subscriptions")
    val subscriptions: java.math.BigDecimal? = null,

    @JsonNames("votes")
    val votes: SubsiteCountersVotes? = null

)

