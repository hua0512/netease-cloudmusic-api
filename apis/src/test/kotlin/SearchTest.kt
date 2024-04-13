import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.apis.search.NeteaseSearchImpl
import github.hua0512.ncm.data.search.NeteaseSearchType
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

/**
 * @author hua0512
 * @date : 2024/4/12 14:24
 */
class SearchTest : BaseNetworkTest() {

    private val impl = NeteaseSearchImpl(client)

    @Test
    fun testSearchTrack() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.TRACK)
        assert(response is NetworkResponse.Success)
        println(response)
    }

    @Test
    fun testSearchAlbum() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.ALBUM)
        assert(response is NetworkResponse.Success)
        println(response)
    }

    @Test
    fun testSearchArtist() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.ARTIST)
        assert(response is NetworkResponse.Success)
        println(response)
    }

    @Test
    fun testSearchPlaylist() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.PLAYLIST)
        assert(response is NetworkResponse.Success)
        println(response)
    }

}