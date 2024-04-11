package github.hua0512.ncm.data.playlist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeteasePlaylistTagDetailed(
    @SerialName("category")
    val category: Int,
    @SerialName("createTime")
    val createTime: Long,
    @SerialName("highQuality")
    val highQuality: Int,
    @SerialName("highQualityPos")
    val highQualityPos: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("officialPos")
    val officialPos: Int,
    @SerialName("position")
    val position: Int,
    @SerialName("type")
    val type: Int,
    @SerialName("usedCount")
    val usedCount: Int
)