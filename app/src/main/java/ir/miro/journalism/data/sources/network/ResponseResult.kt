package ir.miro.journalism.data.sources.network

/**
 * @author mrezaaletaha
 */

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val message: String) : ResponseResult<Nothing>()
}