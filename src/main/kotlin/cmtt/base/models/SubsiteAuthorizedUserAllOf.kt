package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param mHash
 * @param mHashExpirationTime
 * @param userHash
 * @param userHashes
 * @param canChangeAvatar
 * @param canChangeCover
 * @param isBanned
 * @param pushTopic
 * @param bannedInfo
 * @param isSubsitesTuned
 * @param isAdult
 * @param isBlurNsfw
 * @param hidePromoBlocks
 */

data class SubsiteAuthorizedUserAllOf(

    @JsonNames("mHash")
    val mHash: String? = null,

    @JsonNames("mHashExpirationTime")
    val mHashExpirationTime: java.math.BigDecimal? = null,

    @JsonNames("userHash")
    val userHash: String? = null,

    @JsonNames("userHashes")
    val userHashes: List<String>? = null,

    @JsonNames("canChangeAvatar")
    val canChangeAvatar: Boolean? = null,

    @JsonNames("canChangeCover")
    val canChangeCover: Boolean? = null,

    @JsonNames("isBanned")
    val isBanned: Boolean? = null,

    @JsonNames("pushTopic")
    val pushTopic: Boolean? = null,

    @JsonNames("bannedInfo")
    val bannedInfo: SubsiteAuthorizedUserAllOfBannedInfo? = null,

    @JsonNames("isSubsitesTuned")
    val isSubsitesTuned: Boolean? = null,

    @JsonNames("isAdult")
    val isAdult: Boolean? = null,

    @JsonNames("isBlurNsfw")
    val isBlurNsfw: Boolean? = null,

    @JsonNames("hidePromoBlocks")
    val hidePromoBlocks: Boolean? = null

)

