package ir.miro.journalism.data.sources.network

import ir.miro.journalism.data.News

/**
 * @author mrezaaletaha
 */

data class NetworkResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<News>
)