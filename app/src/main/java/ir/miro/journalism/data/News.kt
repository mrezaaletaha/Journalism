package ir.miro.journalism.data

/**
 * @author mrezaaletaha
 */

data class News(
    val id: Int,
    val title: String,
    val url: String,
    val img: String,
    val summary: String,
    val publishedAt: String,
    val updatedAt: String
)
