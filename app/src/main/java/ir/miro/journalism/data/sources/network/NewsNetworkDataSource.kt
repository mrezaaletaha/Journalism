package ir.miro.journalism.data.sources.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author mrezaaletaha
 */

class NewsNetworkDataSource
@Inject constructor(private val apiService: ApiService) : NetworkDataSource {

    override suspend fun loadNews(limit: Int, offset: Int): List<NetworkNews> {
        val response = withContext(Dispatchers.IO) {
            apiService.allNews()
        }
        return response.body()?.results ?: emptyList()
    }
}