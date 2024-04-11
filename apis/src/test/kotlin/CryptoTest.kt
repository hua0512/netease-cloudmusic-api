import github.hua0512.ncm.utils.eapiEncrypt
import github.hua0512.ncm.utils.json
import github.hua0512.ncm.utils.weapiEncrypt
import io.ktor.http.*
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.put
import kotlin.test.Test
import kotlin.test.assertEquals

class CryptoTest {


    @Test
    fun testWeApiEncrypt() {
        val data = buildJsonObject {
            put("username", "Tk1VU0lDIGdtVG82R2lvNEZoRWY5MFZqZzhPenc9PQ==")
            put("csrf_token", "")
        }
        val result = weapiEncrypt(data)
        println(result)
        assert(result["params"] == "PiOwlp8XlU0d3pl2XMP9kF3WCYI2M1N4QXFlZS1XsIl1fmXnhu6SjR+PqPrXEzeC1bHIcmhNV5Fav4oAm1VrZ7oSlJutH8gW2fqFnHMOzGbwGSZrEcRD48kpKA103D7qT+iFVTFONvVslhJZGUtjVQ==")
        assert(result["encSecKey"] == "5a2433cefd81bc3969d7665f513e8f4b907564785aa8a78d20ff4d3aa0f1e217f02e136e2346ad74b0c6f814db90a705249988bac88d0ea0b98e2871a124f7eaf123aa68189d18eb0b420096fa86e73d090ff1bd5d7be606cb49552a9b46f13a969db4b353fa877f5ec00dedeba72ce9b6880f33be63ec3a91d6b405edb940d7")
    }

    @Test
    fun testEapiEncrypt() {
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
        val jsonObject = json.encodeToJsonElement(data).jsonObject
        val encrypted = eapiEncrypt("/api/lbs/countries/v1", jsonObject)
        println(encrypted)
        assertEquals(
            """
    D77118BFBC0EA3CE5716FB04C5611164CC898FBEE48CA98D12E1421CEFABC20462C653E16F38BD1AACF1DD9EB4958BE7C2F0726CE3B188760EFE03848FE5E91BE0310BAF4DBD7E754A741ECF9207CFC96C997E67CE2E4C5E7256D5C9B731C1149DC72EB230CD4018EE1DAF6744E4FD661BCAA9C2AB8E91AEFE5AC12E87A03B5C68972E12B0409D98A2D0A79394E7C48CB828842778F99FFE415A35EECFD5DECC091A0F6B5F915543E440464703D965D858EFA1BCB0E38210127B9B5D94E1CC7CD829CEA84C85976A28DDE3DE93597F0E85E5BC708532DA7F4F7AD3B94CD43AD381BB2AFE0A3F01CD2C3FCEFA748991F980CE594C909CA423C4BF31316CB8BD05F78DF1E06BA37D85A3DA74981FB0641CDF9BC2D4A73F0900CC2DB98A11A3D00C7EF0716D9EDF09CB2FC620A7C660142A6C5CBE69363895BBBF66B3E1312ED796AF539EEC901F21ACA8B9C3C170E5093C1C7A95A87CD5C64A16435DAA7D73DC99164DE0209B8C93B663C666583B793F6B1D10387FC7F3EC48D00A557E40FE5F8B47257382E5898D524349BC3359DCC42FB56EF61522EA11BEED0FE09FB1F58013FE246BCF5A3EEB807301E2678CBEB35BCFCE55E4DB4763CBC8D6AEC7253A17D5
""".trimIndent(), encrypted
        )
    }

    @Test
    fun tests() {
        val cookies =
            """MUSIC_SNS=; Max-Age=0; Expires=Sun, 31 Mar 2024 20:32:38 GMT; Path=/; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/api/clientlog; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/openapi/clientlog; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/neapi/feedback; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/wapi/feedback; Domain=.music.163.com; __remember_me=true; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/; Domain=.music.163.com; NMTID=00Oq-qG3F3YnzHNKU-MtetexKYxdkQAAAGOljbRIQ; Max-Age=315360000; Expires=Wed, 29 Mar 2034 20:32:38 GMT; Path=/; Domain=music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/wapi/feedback; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/weapi/feedback; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/wapi/clientlog; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/eapi/clientlog; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/eapi/clientlog; Domain=.music.163.com; __csrf=7bb6939134b685281a7a601e3030f76c; Max-Age=1296010; Expires=Mon, 15 Apr 2024 20:32:48 GMT; Path=/; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/neapi/feedback; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/api/clientlog; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/weapi/clientlog; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/eapi/feedback; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/openapi/clientlog; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/weapi/clientlog; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/wapi/clientlog; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/neapi/clientlog; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/api/feedback; Domain=.music.163.com; MUSIC_U=004C89B76C167E5526687AF7F0CE23D66626F79B84226769B33F23FA3D49C3E2A83154288326E665770E0B539E905D36736664278D47F78B5852F703A75063C5CBCA6C562AF332C68F5B45A3653CBDD9759BDE431C600CE3343E4700DB6F376031E7688D0FBEB1BCF7FB520FCA3EB49C17CC75C7F26E5122D80B813360CB5124DFEEFB4210C02D32A383667DBF05DDB649ACBEF6862B26700898BA92AC887EF7A8DD0438E138DD6EDC5CFD3F2ABEDE4953131DF39403E122518FE01F8460EA59F1EEACCD25BC4FB59E0310CEFCA3F559D4DC7C8B2DE99932FD17A43F45F2A1C11AEEF6669FF2808450FC8A69EF99ADD30A1DC5B50EE43C63803B8FED961529C30416495AD856F24D7F4D602657EFEB27ED2D5952D624701DCEC285EF6E728668E7A4091EB0E4EB7E2FEAD80ECD877C6860FB248E25E94FC4BD62DE3EFBCB533018D54FDB5D818C1C311493F5477A919F89; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/neapi/clientlog; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/eapi/feedback; Domain=.music.163.com; MUSIC_R_T=1682676397649; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/weapi/feedback; Domain=.music.163.com; MUSIC_A_T=1682676397428; Max-Age=2147483647; Expires=Fri, 18 Apr 2092 23:46:45 GMT; Path=/api/feedback; Domain=.music.163.com"""
        val regex = Regex("""/\s*Domain=[^(;|${'$'})]+;*/""")
        val result = cookies.replace(regex, "")

        // parse all cookies
        val cookiesList = mutableListOf<Cookie>()

        parseServerSetCookieHeader(cookies).also {

            it.toString().also {
                println(it)
            }

            val extensions = it.extensions
            cookiesList.add(Cookie(it.name, it.value, it.encoding, it.maxAge, it.expires, it.domain, it.path, it.secure, it.httpOnly))
            extensions.forEach { (t, u) ->
                cookiesList.add(Cookie(t, u ?: "", it.encoding, it.maxAge, it.expires, it.domain, it.path, it.secure, it.httpOnly))
            }
        }

        println(result)
    }
}