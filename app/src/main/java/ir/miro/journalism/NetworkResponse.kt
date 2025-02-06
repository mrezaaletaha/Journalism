package ir.miro.journalism

import ir.miro.journalism.data.News

/**
 * @author mrezaaletaha
 */

data class NetworkResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val result: List<News>
)