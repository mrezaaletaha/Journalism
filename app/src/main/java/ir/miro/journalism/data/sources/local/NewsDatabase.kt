package ir.miro.journalism.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author mrezaaletaha
 */


@Database(entities = [LocalNews::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}