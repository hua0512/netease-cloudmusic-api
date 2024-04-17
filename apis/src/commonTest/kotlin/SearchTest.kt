import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.apis.search.NeteaseSearchImpl
import github.hua0512.ncm.data.search.NeteaseSearchType
import io.exoquery.kmp.pprint
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * @author hua0512
 * @date : 2024/4/12 14:24
 */
class SearchTest : BaseNetworkTest() {

    private val impl = NeteaseSearchImpl(client)

    @Test
    fun testSearchTrack() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.TRACK)
        assertTrue(response is NetworkResponse.Success)
        println(pprint(response.body))
    }

    @Test
    fun testSearchAlbum() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.ALBUM)
        assertTrue(response is NetworkResponse.Success)
        println(pprint(response.body))
    }

    @Test
    fun testSearchArtist() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.ARTIST)
        assertTrue(response is NetworkResponse.Success)
        println(pprint(response.body))
    }

    @Test
    fun testSearchPlaylist() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.PLAYLIST)
        assertTrue(response is NetworkResponse.Success)
        println(pprint(response.body))
    }

    @Test
    fun testSearchUser() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.USER)
        assertTrue(response is NetworkResponse.Success)
        println(pprint(response.body))
    }

    @Test
    fun testSearchMv() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.MV)
        assertTrue(response is NetworkResponse.Success)
        println(pprint(response.body))
    }

    @Test
    fun testSearchLyric() = runTest {
        val response = impl.search("周杰伦", limit = 10, type = NeteaseSearchType.LYRIC)
        assertTrue(response is NetworkResponse.Success)
        println(pprint(response.body))
    }
}