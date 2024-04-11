import github.hua0512.ncm.apis.track.NeteaseTrackImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

/**
 * @author hua0512
 * @date : 2024/4/8 22:29
 */
class TrackTest : BaseNetworkTest() {
    val trackImpl = NeteaseTrackImpl(client)

    @Test
    fun testGetTracksUrl() = runTest {
        val info = trackImpl.getTracksUrl(listOf("405998841", "33894312"))
        println(info)
    }

    @Test
    fun testGetTracksUrlV1() = runTest {
        val info = trackImpl.getTracksUrlV1(listOf("405998841", "33894312"))
        println(info)
    }


    @Test
    fun testIsPlayable() = runTest {
        val info = trackImpl.isPlayable(listOf("405998841", "33894312"))
        println(info)
    }
}