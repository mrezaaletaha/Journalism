package ir.miro.journalism.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.miro.journalism.data.sources.local.NewsDao
import ir.miro.journalism.data.sources.local.NewsDatabase
import ir.miro.journalism.data.sources.network.NetworkDataSource
import ir.miro.journalism.data.sources.network.ApiService
import ir.miro.journalism.data.sources.network.NewsNetworkDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author mrezaaletaha
 */


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindNetworkDataSource(dataSource: NewsNetworkDataSource): NetworkDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String = "https://api.spaceflightnewsapi.net/"

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NewsDatabase::class.java,
            "journalism.db"
        ).build()
    }

    @Provides
    fun provideNewsDao(database: NewsDatabase): NewsDao = database.newsDao()
}