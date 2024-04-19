package github.hua0512.ncm.utils

import github.hua0512.ncm.apis.base.NetworkResponse
import github.hua0512.ncm.data.RequestMode
import io.ktor.client.statement.*
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

// TODO: Implement body eapiDecrypt
suspend inline fun <reified T, reified U> neteaseResponse(
  mode: RequestMode = RequestMode.WEAPI,
  request: () -> HttpResponse,
): NetworkResponse<T, U> {
  return try {
    // make the request
    val response = request()
    val code = response.status.value

    if (code != 200) {
      // code is not 200
      return response.asNetworkResponse<T, U>()
    }

    // code is 200
    // try to get the body code
    val body = response.bodyAsText()
    val bodyJson = json.parseToJsonElement(body).jsonObject
    val bodyCode = bodyJson["code"]?.jsonPrimitive?.intOrNull ?: 500

    if (bodyCode != 200) {
      // serialize using U
      val error = response.decode<U>()
      return NetworkResponse.ServerError(error, bodyCode, response.headers)
    }
    // code is 200
    response.asNetworkResponse<T, U>()
  } catch (throwable: Throwable) {
    throwable.asNetworkResponse()
  }
}