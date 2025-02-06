package ir.miro.journalism.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.miro.journalism.data.sources.DataSource
import ir.miro.journalism.data.sources.network.ApiClient
import ir.miro.journalism.data.sources.network.NewsNetworkDataSource
import javax.inject.Singleton

/**
 * @author mrezaaletaha
 */


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindNetworkDataSource(dataSource: NewsNetworkDataSource): DataSource
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiClient.ApiService {
        return ApiClient.build()
    }
}