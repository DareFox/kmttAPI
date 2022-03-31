package kmtt.base.models.enums

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

enum class Vote(val value: Int) {
    MINUS(-1),
    PLUS(+1),
    NEUTRAL(0)
}

@Serializer(forClass = Vote::class)
object VoteSerializer : KSerializer<Vote> {
    override fun deserialize(decoder: Decoder): Vote {
        val value = decoder.decodeInt()

        val vote = Vote.values().firstOrNull {
            it.value == value
        }

        requireNotNull(vote)
        return vote
    }

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("vote", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Vote) {
        encoder.encodeInt(value.value)
    }

}