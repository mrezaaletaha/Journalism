package ir.miro.journalism.data.sources.network

import ir.miro.journalism.data.sources.DataSource
import ir.miro.journalism.data.News
import javax.inject.Inject
import ir.miro.journalism.data.sources.network.ApiClient.ApiService

/**
 * @author mrezaaletaha
 */

class NewsNetworkDataSource
@Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun getNews(): ResponseResult<List<News>> {
        return try {
            val response = apiService.allNews()
            response.let {
                if (it.isSuccessful && it.body() != null) {
                    val data = it.body()?.result ?: emptyList()
                    ResponseResult.Success(data)
                } else ResponseResult.Error(response.message())
            }
        } catch (e: Exception) {
            ResponseResult.Error(e.message.toString())
        }
    }
}