@file:OptIn(ExperimentalEncodingApi::class)

package github.hua0512.ncm.utils.encryption

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

/**
 * @author hua0512
 * @date : 2024/4/15 22:30
 */

/**
 * Perform base64 encoding on the given data.
 * @param data The data to be encoded.
 * @return The encoded string.
 */
fun base64Encode(data: ByteArray): String = Base64.Default.encode(data)

/**
 * Perform base64 decoding on the given data.
 * @param data The data to be decoded.
 * @return The decoded byte array.
 */
fun base64Decode(data: String): ByteArray = Base64.Default.decode(data)