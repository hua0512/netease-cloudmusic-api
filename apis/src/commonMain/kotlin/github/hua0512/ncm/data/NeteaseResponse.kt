package github.hua0512.ncm.data

import kotlinx.serialization.Serializable


@Serializable
open class NeteaseResponse {
  open var code: Int = 200

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is NeteaseResponse) return false

    if (code != other.code) return false

    return true
  }

  override fun hashCode(): Int {
    return code
  }

  override fun toString(): String {
    return "NeteaseResponse(code=$code)"
  }
}