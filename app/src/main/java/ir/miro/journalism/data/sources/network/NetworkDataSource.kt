package ir.miro.journalism.data.sources.network

import ir.miro.journalism.data.News
import ir.miro.journalism.data.OperationState

/**
 * @author mrezaaletaha
 */

interface NetworkDataSource {
    suspend fun loadNews() : OperationState<List<News>>
}