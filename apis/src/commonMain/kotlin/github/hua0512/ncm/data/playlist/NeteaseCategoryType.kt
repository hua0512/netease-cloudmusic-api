package github.hua0512.ncm.data.playlist


import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class NeteaseCategoryType(
    val name: String,
)

internal object CategoriesSerializer : KSerializer<List<NeteaseCategoryType>> {

    override val descriptor = ListSerializer(NeteaseCategoryType.serializer()).descriptor

    override fun serialize(encoder: Encoder, value: List<NeteaseCategoryType>) {
        throw NotImplementedError("Serialization is not supported")
    }

    override fun deserialize(decoder: Decoder): List<NeteaseCategoryType> {
        val jsonObject = decoder.decodeSerializableValue(JsonObject.serializer())
        return jsonObject.entries.map { NeteaseCategoryType(it.value.jsonPrimitive.content) }
    }
}