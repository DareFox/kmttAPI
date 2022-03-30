package kmtt.base.models.enums

/**
 * Social account type for authentication
 */
enum class SocialAccountType(val typeValue: String) {
    QR("qr"),
    TWITTER("twitter"),
    FACEBOOK("facebook"),
    VK("vk"),
    GPLUS("googleplus")
}