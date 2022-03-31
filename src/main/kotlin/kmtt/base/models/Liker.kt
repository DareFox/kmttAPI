package kmtt.base.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@kotlinx.serialization.Serializable
data class Liker(
    @SerialName("sign") val vote: Int,
    val name: String,
    @SerialName("avatar_url") val avatarURL: String
)

