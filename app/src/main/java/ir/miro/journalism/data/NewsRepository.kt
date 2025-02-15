package ir.miro.journalism.data

import ir.miro.journalism.data.sources.local.NewsDao
import ir.miro.journalism.data.sources.network.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author mrezaaletaha
 */

class NewsRepository @Inject constructor(
    private val networkDatasource: NetworkDataSource,
    private val localDatasource: NewsDao,
) {

    suspend fun getNewsStream(): List<News> {
        val localNews = withContext(Dispatchers.IO) {
            localDatasource.getAll()
        }
        if (localNews.isEmpty()) {
            refresh()
        }
        return withContext(Dispatchers.Default) {
            localNews.toExternal()
        }
    }

    suspend fun refresh() {
        val remoteNews = withContext(Dispatchers.Default) {
            networkDatasource.loadNews().toLocal()
        }
        localDatasource.deleteAll()
        localDatasource.upsertAll(remoteNews)
    }
}