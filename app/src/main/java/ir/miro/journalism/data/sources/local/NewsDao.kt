package ir.miro.journalism.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author mrezaaletaha
 */

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: List<LocalNews>)

    @Query("DELETE FROM news WHERE createdAt < :expiryTime")
    fun deleteExpiredNews(expiryTime: Long)
}