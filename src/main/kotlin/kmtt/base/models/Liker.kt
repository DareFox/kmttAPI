package kmtt.base.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Liker(
    @SerialName("sign") val vote: Int,
    val name: String,
    val avatarURL: String
)