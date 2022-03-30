package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param socials
 * @param site
 * @param email
 * @param contacts
 */

data class SubsiteContacts(

    @JsonNames("socials")
    val socials: List<SocialAccount>? = null,

    @JsonNames("site")
    val site: SubsiteContactsSite? = null,

    @JsonNames("email")
    val email: String? = null,

    @JsonNames("contacts")
    val contacts: String? = null

)

