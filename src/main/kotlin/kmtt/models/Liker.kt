package kmtt.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable
data class Liker(
    @SerialName("sign") val vote: Int,
    val name: String,
    @SerialName("avatar_url") val avatarURL: String,
)

