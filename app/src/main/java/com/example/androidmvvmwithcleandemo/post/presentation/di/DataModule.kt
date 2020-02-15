package com.example.androidmvvmwithcleandemo.post.presentation.di

import com.example.androidmvvmwithcleandemo.post.data.api.Api
import com.example.androidmvvmwithcleandemo.post.data.mappers.PostDataEntityMapper
import com.example.androidmvvmwithcleandemo.post.data.repositories.CachedDataSource
import com.example.androidmvvmwithcleandemo.post.data.repositories.CachedDataSourceImpl
import com.example.androidmvvmwithcleandemo.post.data.repositories.NetworkDataSourceImpl
import com.example.androidmvvmwithcleandemo.post.data.repositories.PostRepositoryImpl
import com.example.androidmvvmwithcleandemo.post.domain.PostRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 16-02-2020.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    @Named(DI.inMemoryCache)
    fun providesInMemoryCache(): CachedDataSource = CachedDataSourceImpl()

    @Singleton
    @Provides
    fun providesPostRepository(
        postDataEntityMapper: PostDataEntityMapper,
        api: Api, @Named(DI.inMemoryCache) cachedDataSource: CachedDataSource
    ): PostRepository {
        val networkDataSource = NetworkDataSourceImpl(api, postDataEntityMapper)
        return PostRepositoryImpl(networkDataSource, cachedDataSource)
    }


}