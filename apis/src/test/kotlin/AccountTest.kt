import github.hua0512.ncm.apis.user.AccountImpl
import kotlinx.coroutines.test.runTest

import kotlin.test.Test

class AccountTest : BaseNetworkTest() {

    private val impl = AccountImpl(client)

    @Test
    fun testGetUserDetailsInfo() = runTest {
        val info = impl.getUserDetailsInfo("8532318150")
        println(info)
    }


    @Test
    fun testGetAccountInfo() = runTest {
        val info = impl.getAccountInfo()
        println(info)
    }

    @Test
    fun testGetSubCountInfo() = runTest {
        val info = impl.getSubCountInfo()
        println(info)
    }


    fun testGetUserLevelInfo() = runTest {
        val info = impl.getUserLevelInfo()
        println(info)
    }

    @Test
    fun testUserBindingInfo() = runTest {
        val info = impl.getUserBindingInfo("8532318150")
        println(info)
    }

    @Test
    fun testGetPrivateNotificationsCount() = runTest {
        val info = impl.getPrivateNotificationsCount()
        println(info)
    }

    @Test
    fun testGetUserPlaylist() = runTest {
        val info = impl.getUserPlaylist("8532318150")
        println(info)
    }
}