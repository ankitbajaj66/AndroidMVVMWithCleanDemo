package com.example.androidmvvmwithcleandemo.post.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 16-02-2020.
 */
@Module
class AppModule constructor(context: Context) {

    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun providesContext(): Context = appContext

}