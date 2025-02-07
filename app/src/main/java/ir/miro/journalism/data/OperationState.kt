package ir.miro.journalism.data

/**
 * @author mrezaaletaha
 */

sealed class OperationState<out T> {
    data class Success<out T>(val data: T) : OperationState<T>()
    data class Error(val message: String) : OperationState<Nothing>()
}