package ir.miro.journalism.data.sources.network

import ir.miro.journalism.data.News
import ir.miro.journalism.data.OperationState
import javax.inject.Inject

/**
 * @author mrezaaletaha
 */

class NewsNetworkDataSource
@Inject constructor(private val apiService: ApiService) : NetworkDataSource {
    override suspend fun loadNews(limit: Int, offset: Int): OperationState<List<News>> {
        return try {
            val response = apiService.allNews(limit = limit, offset = offset)
            if (response.isSuccessful && response.body() != null) {
                OperationState.Success(response.body()?.results ?: emptyList())
            } else {
                OperationState.Error("${response.code()}: ${response.message()}")
            }
        } catch (e: Exception) {
            OperationState.Error(e.message ?: "Something went wrong")
        }
    }
}