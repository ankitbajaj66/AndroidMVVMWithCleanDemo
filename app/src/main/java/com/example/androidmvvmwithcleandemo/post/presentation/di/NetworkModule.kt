package com.example.androidmvvmwithcleandemo.post.presentation.di

import com.example.androidmvvmwithcleandemo.post.data.api.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 16-02-2020.
 */
@Module
class NetworkModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()
            ).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}