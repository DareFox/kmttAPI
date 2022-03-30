package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param blogs
 * @param sections
 * @param companies
 * @param rating
 * @param forced
 */

data class RecommendedSubsitesResponseResult(

    @JsonNames("blogs")
    val blogs: List<SubsiteSmall>? = null,

    @JsonNames("sections")
    val sections: List<SubsiteSmall>? = null,

    @JsonNames("companies")
    val companies: List<SubsiteSmall>? = null,

    @JsonNames("rating")
    val rating: List<SubsiteSmall>? = null,

    @JsonNames("forced")
    val forced: List<SubsiteSmall>? = null

)

