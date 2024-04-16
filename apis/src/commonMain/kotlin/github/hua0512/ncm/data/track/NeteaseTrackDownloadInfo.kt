package github.hua0512.ncm.data.track

import github.hua0512.ncm.data.NeteaseResponse
import kotlinx.serialization.Serializable

/**
 * @author hua0512
 * @date : 2024/4/9 14:36
 */
@Serializable
data class NeteaseTrackDownloadInfo(
    val id: String,
    val url: String,
    val br: Long,
    val size: Long,
    val md5: String,
    val expi: Long,
    val type: String,
    val gain: Double,
    val peak: Double,
    val fee: Int,
    val uf: String? = null,
    val payed: Int,
    val flag: Int,
    val canExtend: Boolean = false,
    val freeTrialInfo: NeteaseTrialInfo? = null,
    val level: String,
    val encodeType: String,
    val channelLayout: String? = null,
    val freeTrialPrivilege: NeteaseTrackFreeTrialPrivilege? = null,
    val freeTimeTrialPrivilege: NeteaseTrackFreeTrialTimePrivilege? = null,
    val urlSource: Int,
    val rightSource: Int,
    val podcastCtrp: String? = null,
    val effectTypes: String? = null,
    val time: Long,
    val message: String? = null
) : NeteaseResponse()
