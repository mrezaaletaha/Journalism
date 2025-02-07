package ir.miro.journalism.data

import com.google.gson.annotations.SerializedName

/**
 * @author mrezaaletaha
 */

data class News(
    val id: Int,
    val title: String,
    val url: String,
    @SerializedName("image_url") val img: String,
    val summary: String,
    val publishedAt: String,
    val updatedAt: String
)
