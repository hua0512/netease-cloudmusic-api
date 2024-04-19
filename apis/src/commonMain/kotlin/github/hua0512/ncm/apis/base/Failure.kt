package github.hua0512.ncm.apis.base


sealed class Failure(val exception: Exception) {

  data class HttpErrorInternalServerError(val error: Exception) : Failure(error)

  data class HttpErrorBadRequest(val error: Exception) : Failure(error)

  data class HttpErrorUnauthorized(val error: Exception) : Failure(error)

  data class HttpErrorForbidden(val error: Exception) : Failure(error)

  data class HttpErrorNotFound(val error: Exception) : Failure(error)

  data class HttpError(val error: Exception) : Failure(error)

  data class GenericError(val error: Exception) : Failure(error)
}
