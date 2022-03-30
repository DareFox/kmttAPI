package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param type
 * @param `data`
 */

data class TimelineItem(

    @JsonNames("type")
    val type: TimelineItem.Type? = null,
//
//    @JsonNames( "data")
//    val `data`: OneOfLessThanObjectCommaArrayCommaArrayCommaEntryGreaterThan? = null

) {

    /**
     *
     *
     * Values: news,entry,vacancies,events,onboarding,flash,rating
     */
    enum class Type(val value: String) {
        @JsonNames("news")
        news("news"),

        @JsonNames("entry")
        entry("entry"),

        @JsonNames("vacancies")
        vacancies("vacancies"),

        @JsonNames("events")
        events("events"),

        @JsonNames("onboarding")
        onboarding("onboarding"),

        @JsonNames("flash")
        flash("flash"),

        @JsonNames("rating")
        rating("rating");
    }
}

