@file:OptIn(ExperimentalStdlibApi::class)

import github.hua0512.ncm.apis.login.LoginImpl
import github.hua0512.ncm.utils.toMd5
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class LoginTest : BaseNetworkTest() {

  @Test
  fun testLoginByPhone() = runTest {
    val login = LoginImpl(client)
    val md5Password = "cola0512+".toMd5()
    val result = login.loginByPhone("611617796", "", "34", md5Password, null)
    println(result)
  }

  @Test
  fun testLoginStatus() = runTest {
    val login = LoginImpl(client)
    val result = login.loginStatus()
    println(result)
  }

}
