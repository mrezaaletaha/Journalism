package ir.miro.journalism.data.sources.network

import ir.miro.journalism.data.News
import ir.miro.journalism.data.OperationState

/**
 * @author mrezaaletaha
 */

interface NetworkDataSource {
    suspend fun loadNews(
        limit: Int = 10,
        offset: Int = 0
    ): OperationState<List<News>>
}