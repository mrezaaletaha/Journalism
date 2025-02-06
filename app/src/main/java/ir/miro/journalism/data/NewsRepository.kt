package ir.miro.journalism.data

import ir.miro.journalism.data.sources.DataSource
import javax.inject.Inject

/**
 * @author mrezaaletaha
 */

class NewsRepository @Inject constructor(private val datasource: DataSource) {

    suspend fun fetchData() {
        datasource.getNews()
    }

}