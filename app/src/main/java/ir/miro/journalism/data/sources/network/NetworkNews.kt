package ir.miro.journalism.data.sources.network

import com.google.gson.annotations.SerializedName

/**
 * @author mrezaaletaha
 */

data class NetworkNews(
    val id: Int,
    val title: String,
    val url: String,
    @SerializedName("image_url") val img: String,
    val summary: String,
    @SerializedName("published_at") val publishedAt: String,
    @SerializedName("updated_at") val updatedAt: String
)