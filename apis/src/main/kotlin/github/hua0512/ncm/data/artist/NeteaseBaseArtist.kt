package github.hua0512.ncm.data.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class NeteaseBaseArtist {
    @SerialName("alias")
    open var alias: List<String>? = emptyList()

    @SerialName("id")
    open var id: Int = 0

    @SerialName("name")
    open var name: String = ""

    @SerialName("tns")
    var tns: List<String>? = emptyList()

    override fun toString(): String {
        return "NeteaseArtist(alias=$alias, id=$id, name='$name', tns=$tns)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NeteaseBaseArtist

        if (alias != other.alias) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (tns != other.tns) return false

        return true
    }

    override fun hashCode(): Int {
        var result = alias?.hashCode() ?: 0
        result = 31 * result + id
        result = 31 * result + name.hashCode()
        result = 31 * result + (tns?.hashCode() ?: 0)
        return result
    }


}