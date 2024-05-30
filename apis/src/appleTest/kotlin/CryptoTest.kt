@file:OptIn(ExperimentalStdlibApi::class, ExperimentalForeignApi::class)

import github.hua0512.ncm.utils.Crypto.aesECBDecrypt
import github.hua0512.ncm.utils.Crypto.aesECBEncrypt
import github.hua0512.ncm.utils.Crypto.rsaEncrypt
import github.hua0512.ncm.utils.encryption.AESPadding
import io.ktor.utils.io.core.*
import kotlinx.cinterop.*
import platform.Foundation.create
import platform.posix.*
import kotlin.io.encoding.Base64
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.text.String

class CryptoAppleTest {

    @Test
    fun testAESEncryption() {
        val text = "NeteaseCloudMusicApi"
        val key = "1234567890123456"
        val expectedBase64 = "EfimgRVfHcgXw4mGRydlrJo2G8PtMGcKhP4LKUE0Ijw="
        val expected = expectedBase64.decodeBase64()

        val encrypted = aesECBEncrypt(text, key, AESPadding.PKCS5Padding)

        assertEquals(expected.toHexString(), encrypted.toHexString())
    }

    @Test
    fun testAESDecryption() {
        val encryptedBase64 = "EfimgRVfHcgXw4mGRydlrJo2G8PtMGcKhP4LKUE0Ijw="
        val key = "1234567890123456"
        val expectedText = "NeteaseCloudMusicApi"

        val decryptedBytes = aesECBDecrypt(encryptedBase64, key, AESPadding.PKCS5Padding)
        val decrypted = decryptedBytes.decodeToString()

        assertEquals(expectedText, decrypted)
    }

    @Test
    fun testRSAEncryption() {
        val text = "NeteaseCloudMusicApi"
        val publicKeyBase64 = "-----BEGIN PUBLIC KEY-----\n" +
                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbwu5aMKqqmuZ8a1LVdhm/qrLCPixuvrBDzJ9ikM7QL9K6QRmcgbrM1MdEioiXNlLdSkXjTb1cdZbklgEPGmQOkvv7IpVdIXOhYLwRUIctny9Y2ln4F47Y8MeKviR4BvUdZraILt1VBAWBFayM7RcZU6qyMdzk/LSjXJavFio5MQIDAQAB\n" +
                "-----END PUBLIC KEY-----"
        val publicKey = publicKeyBase64.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("\n-----END PUBLIC KEY-----", "").decodeBase64()
        val expectedBase64 = "Y4bq7UzSIDjQCVzv2H1iVGSLMhP7Up688crkCHttmib5uPyPWiHv2GS7tdUG7h4DrsHnousME95aD5qXPZxFPR/VQSrw1H5C22dVy9ah0f92Lhxj7V8Og9wt7VZImvewyi17traxYcSI9G9WOFmvG+ChXBpZK8Qq/BfHy7BmwiA="
        val expected = expectedBase64.decodeBase64()

        val encrypted = rsaEncrypt(text, publicKey)

        println("Encrypted: ${encrypted.toHexString()}")
        println("Expected: ${expected.toHexString()}")

        assertEquals(expected.toHexString(), encrypted.toHexString())
    }
}

// Extension function to decode Base64 string to ByteArray
@OptIn(BetaInteropApi::class)
fun String.decodeBase64(): ByteArray = platform.Foundation.NSData.create(base64EncodedString = this, options = 0u)!!.toByteArray()

// Extension function to convert NSData to ByteArray
fun platform.Foundation.NSData.toByteArray(): ByteArray {
    val bytes = ByteArray(this.length.toInt())
    bytes.usePinned {
        memcpy(it.addressOf(0), this.bytes, this.length)
    }
    return bytes
}
