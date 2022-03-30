package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param type
 * @param `data`
 */

data class TimelineSubItem(

    @JsonNames("type")
    val type: TimelineSubItem.Type? = null,

    @JsonNames("data")
    val `data`: OneOfLessThanArrayCommaArrayGreaterThan? = null

) {

    /**
     *
     *
     * Values: vacancy,event
     */
    enum class Type(val value: String) {
        @JsonNames("vacancy")
        vacancy("vacancy"),

        @JsonNames("event")
        event("event");
    }
}

