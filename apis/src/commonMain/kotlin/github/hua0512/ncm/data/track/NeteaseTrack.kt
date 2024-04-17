package github.hua0512.ncm.data.track


import github.hua0512.ncm.data.album.NeteaseAlbumDetailed
import github.hua0512.ncm.data.artist.NeteaseBaseArtist
import github.hua0512.ncm.data.lyric.NeteaseBaseLyric
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
    @SerialName("audition")
    val audition: String? = null,
    @SerialName("al")
    val album: NeteaseAlbumDetailed? = null,
    @SerialName("alia")
    val alia: List<String>? = emptyList(),
    @JsonNames("ar", "artists")
    val artists: List<NeteaseBaseArtist>,
    @SerialName("awardTags")
    val awardTags: List<String>? = emptyList(),
    @JsonNames("cd", "disc")
    val cd: String,
    @SerialName("cf")
    val cf: String? = null,
    @SerialName("copyright")
    val copyright: Int,
    @SerialName("copyrightId")
    val copyrightId: Int? = 0,
    @SerialName("cp")
    val cp: Int? = 0,
    @SerialName("crbt")
    val crbt: String? = null,
    @SerialName("djId")
    val djId: Int? = 0,
    @JsonNames("dt", "duration")
    val duration: Int,
    @SerialName("entertainmentTags")
    val entertainmentTags: List<String>? = emptyList(),
    @SerialName("fee")
    val fee: Int,
    @SerialName("ftype")
    val ftype: Int,
    @JsonNames("h", "hMusic")
    val highQuality: NeteaseTrackQuality? = null,
    @SerialName("hr")
    val highResolution: NeteaseTrackQuality? = null,
    @SerialName("id")
    val id: Int,
    @JsonNames("l", "lMusic")
    val lowQuality: NeteaseTrackQuality? = null,
    @JsonNames("m", "mMusic")
    val mediumQuality: NeteaseTrackQuality? = null,
    @JsonNames("b", "bMusic")
    val baseQuality: NeteaseTrackQuality? = null,
    @SerialName("mark")
    val mark: Long? = 0,
    @SerialName("mst")
    val mst: Int? = 0,
    @JsonNames("mv", "mvid")
    val mv: Int,
    @SerialName("name")
    val name: String,
    @SerialName("no")
    val no: Int,
    @SerialName("noCopyrightRcmd")
    val noCopyrightRcmd: String? = null,
    @SerialName("originCoverType")
    val originCoverType: Int? = 0,
    @SerialName("originSongSimpleData")
    val originSongSimpleData: NeteaseOriginTrackData? = null,
    @JsonNames("pop", "popularity")
    val popularity: Double,
    @SerialName("pst")
    val pst: Int? = 0,
    @SerialName("publishTime")
    val publishTime: Long? = 0,
    @SerialName("resourceState")
    val resourceState: Boolean? = false,
    @SerialName("rt")
    val rt: String? = null,
    @SerialName("rtUrl")
    val rtUrl: String?,
    @SerialName("rtUrls")
    val rtUrls: List<String>,
    @SerialName("rtype")
    val rtype: Int,
    @SerialName("rurl")
    val rurl: String?,
    @SerialName("s_id")
    val sId: Int? = 0,
    @SerialName("single")
    val single: Int? = 0,
    @SerialName("songJumpInfo")
    val songJumpInfo: String? = null,
    @SerialName("sq")
    val superQuality: NeteaseTrackQuality? = null,
    @JsonNames("st", "status")
    val status: Int,
    @SerialName("t")
    val t: Int? = 0,
    @SerialName("tagPicList")
    val tagPicList: List<String>? = emptyList(),
    @SerialName("tns")
    val tns: List<String>? = emptyList(),
    @JsonNames("v", "version")
    val version: Int? = 0,
    @SerialName("position")
    val position: Int? = 0,
    @SerialName("starred")
    val starred: Boolean? = false,
    @SerialName("score")
    val score: Int? = null,
    @SerialName("starredNum")
    val starredNum: Int? = 0,
    @SerialName("playedNum")
    val playedNum: Int? = 0,
    @SerialName("dayPlays")
    val dayPlays: Int? = 0,
    @SerialName("hearTime")
    val hearTime: Int? = 0,
    @SerialName("ringtone")
    val ringtone: String? = null,
    @SerialName("commentThreadId")
    val commentThreadId: String? = null,
    @SerialName("mp3Url")
    val mp3Url: String? = null,
    @SerialName("lyrics")
    val lyrics: NeteaseBaseLyric? = null,
)