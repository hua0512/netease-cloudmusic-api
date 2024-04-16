package github.hua0512.ncm.utils

import github.hua0512.ncm.utils.encryption.AESPadding

internal expect object Crypto {

    fun aesECBEncrypt(text: String, key: String, paddingMode: AESPadding): ByteArray

    fun aesECBDencrypt(text: String, key: String, paddingMode: AESPadding): ByteArray

    fun rsaEncrypt(str: String, key: ByteArray): ByteArray

}

