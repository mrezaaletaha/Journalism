package ir.miro.journalism.data.sources.network

/**
 * @author mrezaaletaha
 */

interface NetworkDataSource {
    suspend fun loadNews(
        limit: Int = 10,
        offset: Int = 0
    ): List<NetworkNews>
}