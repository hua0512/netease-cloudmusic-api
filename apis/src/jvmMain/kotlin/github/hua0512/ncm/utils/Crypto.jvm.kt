package github.hua0512.ncm.utils

import github.hua0512.ncm.utils.encryption.AESPadding
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

internal actual object Crypto {

    actual fun rsaEncrypt(str: String, key: ByteArray): ByteArray {
        val spec = X509EncodedKeySpec(key)
        val keyFactory = KeyFactory.getInstance("RSA")
        val publicKey = keyFactory.generatePublic(spec)

        val cipher = Cipher.getInstance("RSA/ECB/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        return cipher.doFinal(str.toByteArray(Charsets.UTF_8))
    }

    actual fun aesECBEncrypt(text: String, key: String, paddingMode: AESPadding): ByteArray {
        val secretKey = SecretKeySpec(key.toByteArray(StandardCharsets.UTF_8), "AES")
        val cipher = Cipher.getInstance("AES/ECB/${paddingMode.mode}").apply {
            init(Cipher.ENCRYPT_MODE, secretKey)
        }
        return cipher.doFinal(text.toByteArray(StandardCharsets.UTF_8))
    }

    actual fun aesECBDencrypt(text: String, key: String, paddingMode: AESPadding): ByteArray {
        val secretKey = SecretKeySpec(key.toByteArray(StandardCharsets.UTF_8), "AES")
        val cipher = Cipher.getInstance("AES/ECB/${paddingMode.mode}").apply {
            init(Cipher.DECRYPT_MODE, secretKey)
        }
        return cipher.doFinal(text.toByteArray(StandardCharsets.UTF_8))
    }
}