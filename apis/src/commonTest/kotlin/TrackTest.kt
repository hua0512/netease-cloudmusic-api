import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.apis.track.NeteaseTrackImpl
import io.exoquery.kmp.pprint
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * @author hua0512
 * @date : 2024/4/8 22:29
 */
class TrackTest : BaseNetworkTest() {
  val trackImpl = NeteaseTrackImpl(client)

  @Test
  fun testGetTracksUrl() = runTest {
    val info = trackImpl.getTracksUrl(listOf("405998841", "33894312"))
    assertTrue(info is NetworkResponse.Success)
    println(pprint(info.body))
  }

  @Test
  fun testGetTracksUrlV1() = runTest {
    val info = trackImpl.getTracksUrlV1(listOf("405998841", "33894312"))
    assertTrue(info is NetworkResponse.Success)
    println(pprint(info.body))
  }


  @Test
  fun testIsPlayable() = runTest {
    val info = trackImpl.isPlayable(listOf("405998841", "33894312"))
    assertTrue(info is NetworkResponse.Success)
    println(pprint(info.body))
  }
}