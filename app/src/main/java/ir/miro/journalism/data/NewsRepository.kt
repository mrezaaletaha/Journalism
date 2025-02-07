package ir.miro.journalism.data

import ir.miro.journalism.data.sources.network.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author mrezaaletaha
 */

class NewsRepository @Inject constructor(
    private val datasource: NetworkDataSource,
) {
    suspend fun fetchNews(): OperationState<List<News>> {
        return withContext(Dispatchers.IO) {
            datasource.loadNews()
        }
    }
}