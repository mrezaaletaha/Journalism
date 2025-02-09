package ir.miro.journalism.data.sources.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author mrezaaletaha
 */

@Entity(tableName = "news")
data class LocalNews(
    @PrimaryKey val id: Int = 0,
    val title: String,
    val description: String,
    val imageUrl: String,
    val createdAt: Long
)