package github.hua0512.ncm.utils

import github.hua0512.ncm.apis.base.NetworkResponse
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import io.ktor.util.network.*
import io.ktor.utils.io.errors.*
import kotlinx.serialization.SerializationException

/**
 * Transform a request made by a Ktor client to NetworkResponse
 */
@Suppress("FunctionNaming")
public suspend inline fun <reified T, reified U> networkResponse(
    request: () -> HttpResponse,
): NetworkResponse<T, U> = try {
    request().asNetworkResponse()
} catch (throwable: Throwable) {
    throwable.asNetworkResponse()
}

suspend inline fun <reified T, reified U> HttpResponse.asNetworkResponse(): NetworkResponse<T, U> =
    with(this) { NetworkResponse.Success(decode(), headers, status.value) }

suspend inline fun <reified T, reified U> ResponseException.serializeAsError(): NetworkResponse<T, U> =
    try {
        with(response) { NetworkResponse.ServerError(decode(), status.value, headers) }
    } catch (throwable: Throwable) {
        // check if is a failed decode, if so, decode as U
        if (throwable is SerializationException || throwable is IllegalArgumentException) {
            with(response) { NetworkResponse.ServerError(decode<U>(), status.value, headers) }
        } else
            NetworkResponse.UnknownError(throwable)
    }


suspend inline fun <reified T> HttpResponse.decode(): T {
    val text = bodyAsText()
    println("body: $text")
    return json.decodeFromString<T>(text)
}

suspend inline fun <reified T : Any, reified U : Any> Throwable.asNetworkResponse(): NetworkResponse<T, U> =
    when (this) {
        is ResponseException -> serializeAsError()
        is UnresolvedAddressException -> NetworkResponse.RemoteError(this)
        is IOException -> NetworkResponse.NetworkError(this)
        else -> NetworkResponse.UnknownError(this)
    }