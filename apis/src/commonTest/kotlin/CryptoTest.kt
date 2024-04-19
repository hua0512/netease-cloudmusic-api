import github.hua0512.ncm.utils.eapiEncrypt
import github.hua0512.ncm.utils.encryption.AESMode
import github.hua0512.ncm.utils.encryption.AESPadding
import github.hua0512.ncm.utils.encryption.aesEncrypt
import github.hua0512.ncm.utils.encryption.base64Encode
import github.hua0512.ncm.utils.toMd5
import github.hua0512.ncm.utils.weapiEncrypt
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlin.test.Test
import kotlin.test.assertEquals

class CryptoTest {


  @Test
  fun testWeApiEncrypt() = runTest {
    val data = buildJsonObject {
      put("username", "Tk1VU0lDIGdtVG82R2lvNEZoRWY5MFZqZzhPenc9PQ==")
      put("csrf_token", "")
    }
    val result = weapiEncrypt(data)
    println(result)
    assertEquals(
      "PiOwlp8XlU0d3pl2XMP9kF3WCYI2M1N4QXFlZS1XsIl1fmXnhu6SjR+PqPrXEzeC1bHIcmhNV5Fav4oAm1VrZ7oSlJutH8gW2fqFnHMOzGbwGSZrEcRD48kpKA103D7qT+iFVTFONvVslhJZGUtjVQ==",
      result["params"]
    )
    assertEquals(
      "5a2433cefd81bc3969d7665f513e8f4b907564785aa8a78d20ff4d3aa0f1e217f02e136e2346ad74b0c6f814db90a705249988bac88d0ea0b98e2871a124f7eaf123aa68189d18eb0b420096fa86e73d090ff1bd5d7be606cb49552a9b46f13a969db4b353fa877f5ec00dedeba72ce9b6880f33be63ec3a91d6b405edb940d7",
      result["encSecKey"]
    )
  }

  @Test
  fun testEapiEncrypt() = runTest {
    val data = mapOf(
      "osver" to "17,1,2",
      "appver" to "8.20.21",
      "versioncode" to "140",
      "buildver" to "1712146964",
      "resolution" to "1920x1080",
      "__csrf" to "",
      "os" to "ios",
      "requestId" to "1712146964371_0219",
      "MUSIC_A" to "1f5fa7b6a6a9f81a11886e5186fde7fb7facfa5890227ce5acd1a6a9477772d14b7f5273fc3921d1f2dea87316bc5d0f90f11f1b0cda7a57cc5a946f5cd71342655994baaa79aac33324751bcc9aaf44c3061cd18d77b7a0"
    )
    val jsonObject = buildJsonObject {
      data.forEach { (k, v) -> put(k, v) }
    }
    val encrypted = eapiEncrypt("/api/lbs/countries/v1", jsonObject)
    assertEquals(
      """
    D77118BFBC0EA3CE5716FB04C5611164CC898FBEE48CA98D12E1421CEFABC20421C93CACE2174F7B7F8BDACFFAD2CD33C9AA397DA5E07280308A61C9CE429C6F2E34D29B031532C405BD5F9E808A67CBA4420851816008E64E0D7F9A2F6B8458A630631DA3F825E692EF172680FE254519D96F59BCEDDFB8A20DA5CE90ABCCFC6869FD0A3BBC640BBD38EB704AE42BFD072E5BE5D1C3A9E08F74C2782E03A6BA258A3F87BB2DF47C3A615B7EC87B92D96F565DA9D2E0D84B93CCBB0D74F496E009B7F770C508F4FA2CDE890B5D9494E107F23A2F27E1FF0270F74EF735D2A12E27E5E4CD892B1C31922D9BAB5A21B0DEA69657D4BB5A858065D668F3533154B7EE634BF9A2EAA7299866EB6D9AE8B8D3B474A5E38EB96585D59C66A1FABED1FFAC597A8337F43E832F3E0EEA5D4A7389BBBDD316B86D0EEC213738E26EA69DBC2E91730A178C11294E00346BE29C7189419491D8AAFC429BA1EC378A60A9FCDD26DC9B62D6F5DA521B004567631B832A6D45ED78819B4E9BBDCB744124A013143C1E234C775C4E240F3200F9021386271CE54A275D45547ACFF662855D9402BE307193F90F866F5A1E30161DF627FE7A
""".trimIndent(), encrypted
    )
  }

  @Test
  fun testAESCBC() = runTest {
    val encrypt = aesEncrypt(
      """{"csrf_token":""}""",
      AESMode.CBC,
      AESPadding.PKCS5Padding,
      "0CoJUm6Qyw8W8jud",
      "0102030405060708"
    )
    assertEquals("eHhjXckqrtZkqcwCalCMx0QuU6Lj9L7Wxouw1iMCnB4=", base64Encode(encrypt))
  }

  @Test
  fun testMD5() = runTest {
    val md5 = "123456".toMd5()
    assertEquals("e10adc3949ba59abbe56e057f20f883e", md5)
  }
}