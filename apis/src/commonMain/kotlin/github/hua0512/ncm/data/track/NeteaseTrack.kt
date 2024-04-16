package github.hua0512.ncm.data.track


import github.hua0512.ncm.data.artist.NeteaseBaseArtist
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class NeteaseTrack(
    /**
     * TODO : what is this?
     */
    @SerialName("a")
    val a: String? = null,
    @SerialName("al")
    val al: NeteaseMusicAlbum? = null,
    @SerialName("alia")
    val alia: List<String>? = emptyList(),
    @SerialName("ar")
    val artists: List<NeteaseBaseArtist>,
    @SerialName("awardTags")
    val awardTags: List<String>? = emptyList(),
    @JsonNames("cd", "disc")
    val cd: String,
    @SerialName("cf")
    val cf: String,
    @SerialName("copyright")
    val copyright: Int,
    @SerialName("cp")
    val cp: Int,
    @SerialName("crbt")
    val crbt: String? = null,
    @SerialName("djId")
    val djId: Int,
    @SerialName("dt")
    val dt: Int,
    @SerialName("entertainmentTags")
    val entertainmentTags: List<String>? = emptyList(),
    @SerialName("fee")
    val fee: Int,
    @SerialName("ftype")
    val ftype: Int,
    @SerialName("h")
    val highQuality: NeteaseTrackQuality? = null,
    @SerialName("hr")
    val highResolution: NeteaseTrackQuality? = null,
    @SerialName("id")
    val id: Int,
    @SerialName("l")
    val lowQuality: NeteaseTrackQuality? = null,
    @SerialName("m")
    val mediumQuality: NeteaseTrackQuality? = null,
    @SerialName("mark")
    val mark: Long,
    @SerialName("mst")
    val mst: Int,
    @SerialName("mv")
    val mv: Int,
    @SerialName("name")
    val name: String,
    @SerialName("no")
    val no: Int,
    @SerialName("noCopyrightRcmd")
    val noCopyrightRcmd: String?,
    @SerialName("originCoverType")
    val originCoverType: Int,
    @SerialName("originSongSimpleData")
    val originSongSimpleData: NeteaseOriginTrackData? = null,
    @SerialName("pop")
    val pop: Double,
    @SerialName("pst")
    val pst: Int,
    @SerialName("publishTime")
    val publishTime: Long,
    @SerialName("resourceState")
    val resourceState: Boolean,
    @SerialName("rt")
    val rt: String,
    @SerialName("rtUrl")
    val rtUrl: String?,
    @SerialName("rtUrls")
    val rtUrls: List<String>,
    @SerialName("rtype")
    val rtype: Int,
    @SerialName("rurl")
    val rurl: String?,
    @SerialName("s_id")
    val sId: Int,
    @SerialName("single")
    val single: Int,
    @SerialName("songJumpInfo")
    val songJumpInfo: String?,
    @SerialName("sq")
    val superQuality: NeteaseTrackQuality,
    @SerialName("st")
    val st: Int,
    @SerialName("t")
    val t: Int,
    @SerialName("tagPicList")
    val tagPicList: List<String>? = emptyList(),
    @SerialName("tns")
    val tns: List<String>? = emptyList(),
    @SerialName("v")
    val v: Int,
    @SerialName("version")
    val version: Int
)