package com.example.androidmvvmwithcleandemo.post.presentation.common

import android.app.Application
import com.example.androidmvvmwithcleandemo.post.presentation.di.*
import com.example.practice.dagger.daggersingleton.DaggerActivityComponent

/**
 *Created by Ankit Bajaj on 16-02-2020.
 */
class App : Application() {

    lateinit var mainComponent: MainComponent
    private var postDetailsComponent: PostDetailsComponent? = null

    override fun onCreate() {
        super.onCreate()

        initDependencies()
    }

    private fun initDependencies() {
        mainComponent =
            DaggerMainComponent.builder().appModule(AppModule(applicationContext)).networkModule(
                NetworkModule("https://jsonplaceholder.typicode.com")
            ).dataModule(DataModule()).build()
    }

    fun createPostComponent(): PostDetailsComponent {
        postDetailsComponent = mainComponent.plusPostDetails(PostDetailsModule())
        return postDetailsComponent!!
    }

    fun releasePostComponent() {
        postDetailsComponent = null
    }
}