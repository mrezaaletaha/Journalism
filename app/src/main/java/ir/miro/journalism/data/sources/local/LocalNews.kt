package ir.miro.journalism.data.sources.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author mrezaaletaha
 */

@Entity(tableName = "news")
data class LocalNews(
    @PrimaryKey val id: Int = 1,
    val title: String,
    val summary: String,
    val imageUrl: String,
    val url: String,
    val publishedAt: String,
    val updatedAt: String,
    val createdAt: Long
)