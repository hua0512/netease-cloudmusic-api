import github.hua0512.ncm.apis.country.CountryImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class CountryTest : BaseNetworkTest() {

    @Test
    fun testGetCountriesCode() = runTest {
        val contryImpl = CountryImpl(client)
        val response = contryImpl.getCountriesCode()
        println(response)
    }
}