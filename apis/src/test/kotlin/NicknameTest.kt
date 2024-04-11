import github.hua0512.ncm.apis.nickname.NicknameImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class NicknameTest : BaseNetworkTest() {

    @Test
    fun testCheckNick() = runTest {
        val info = NicknameImpl(client).checkNick("别再打扰我了")
        println(info)
    }
}