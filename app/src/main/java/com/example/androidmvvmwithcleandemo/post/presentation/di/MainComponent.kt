package com.example.androidmvvmwithcleandemo.post.presentation.di

import dagger.Component
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 16-02-2020.
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface MainComponent {
    fun plusPostDetails(postDetailsModule: PostDetailsModule): PostDetailsComponent
}