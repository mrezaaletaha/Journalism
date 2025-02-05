package ir.miro.journalism

/**
 * @author mrezaaletaha
 */

data class NewsItem(
    val id: Int,
    val title: String,
    val url: String,
    val img: String,
    val summary: String,
    val publishedAt: String,
    val updatedAt: String
)
