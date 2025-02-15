package ir.miro.journalism.data.sources.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

/**
 * @author mrezaaletaha
 */

@Dao
interface NewsDao {

    @Query("SELECT * FROM news ORDER BY id DESC")
    fun observeAll(): Flow<List<LocalNews>>

    @Upsert
    suspend fun upsertAll(news: List<LocalNews>)

    @Query("SELECT * FROM news ORDER BY id DESC")
    suspend fun getAll(): List<LocalNews>

    @Query("DELETE FROM news WHERE createdAt < :expiryTime")
    fun deleteExpiredNews(expiryTime: Long)

    @Query("DELETE FROM news")
    suspend fun deleteAll()
}