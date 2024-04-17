package github.hua0512.ncm.data.album

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/16 21:50
 */
@Serializable
open class NeteaseBaseAlbum {
    @SerialName("id")
    var id: Int = 0

    @SerialName("name")
    var name: String = ""

    @SerialName("pic")
    var pic: Long? = null

    @SerialName("pic_str")
    var picStr: String? = null

    @SerialName("picUrl")
    var picUrl: String? = null

    @SerialName("tns")
    var tns: List<String>? = emptyList()
}
