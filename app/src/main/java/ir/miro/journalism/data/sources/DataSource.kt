package ir.miro.journalism.data.sources

import ir.miro.journalism.data.News
import ir.miro.journalism.data.sources.network.ResponseResult

/**
 * @author mrezaaletaha
 */

interface DataSource {
    suspend fun getNews() : ResponseResult<List<News>>
}