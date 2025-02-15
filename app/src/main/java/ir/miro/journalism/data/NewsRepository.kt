package ir.miro.journalism.data

import android.util.Log
import ir.miro.journalism.data.sources.local.NewsDao
import ir.miro.journalism.data.sources.network.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

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
            return getNewsStream()
        }

        return localNews.toExternal()
    }

    suspend fun refresh() {
        try {
            val remoteNews = withContext(Dispatchers.Default) {
                networkDatasource.loadNews().toLocal()
            }
            withContext(Dispatchers.IO) {
                localDatasource.deleteAll()
                localDatasource.upsertAll(remoteNews)
            }
        } catch (e: Exception) {

        }
    }
}