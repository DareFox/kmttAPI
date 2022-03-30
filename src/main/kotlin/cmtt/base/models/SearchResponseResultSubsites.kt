package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param users
 * @param sections
 * @param companies
 */

data class SearchResponseResultSubsites(

    @JsonNames("users")
    val users: List<SubsiteSmall>? = null,

    @JsonNames("sections")
    val sections: List<SubsiteSmall>? = null,

    @JsonNames("companies")
    val companies: List<SubsiteSmall>? = null

)

