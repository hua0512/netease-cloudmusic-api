import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.apis.playlist.PlaylistImpl
import io.exoquery.kmp.pprint
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue


class PlaylistTest : BaseNetworkTest() {


  val impl = PlaylistImpl(client)

  @Test
  fun testUpdatePlaylist() = runTest {
    val info = impl.updatePlaylist("8384059416", "Work hard", "健身专用", listOf("欧美"))
    println(info)
  }

  @Test
  fun updatePlaylistOrder() = runTest {
    val info = impl.updatePlaylistOrder(listOf("8384211343", "8384059416"))
    println(info)
  }

  @Test
  fun testGetHotPlaylistTags() = runTest {
    val info = impl.getHotPlaylistTags()
    println(info)
  }

  @Test
  fun testGetCategoryPlaylists() = runTest {
    val info = impl.getCategoryPlaylists()
    println(info)
  }

  @Test
  fun testGetTopPlaylists() = runTest {
    val info = impl.getTopPlaylists("全部", null, 10, 0)
    println(info)
  }

  @Test
  fun testGetHighQualityPlaylists() = runTest {
    val info = impl.getHighQualityPlaylists("全部", 10, 0)
    println(info)
  }

  @Test
  fun testGetPlaylistDetail() = runTest {
    val info = impl.getPlaylistDetail("8280551582")
    assertTrue(info is NetworkResponse.Success)
    println(pprint(info.body))
  }

  @Test
  fun testGetPlaylistTracks() = runTest {
    val info = impl.getPlaylistTracks("8280551582")
    assertTrue(info is NetworkResponse.Success)
    println(pprint(info.body))
  }

  @Test
  fun testGetPlaylistDetailDynamic() = runTest {
    val info = impl.getPlaylistDetailDynamic("8280551582")
    println(info)
  }

  @Test
  fun testUpdatePlaylistCount() = runTest {
    val info = impl.updatePlaylistCount("8280551582")
    println(info)
  }

}


