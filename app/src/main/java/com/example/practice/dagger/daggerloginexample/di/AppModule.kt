package com.example.practice.dagger.daggerloginexample.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.androidmvvmwithcleandemo.R
import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 13-02-2020.
 */
@Module
abstract class AppModule {
    companion object {
        @Provides
        fun providesRequestOptions(): RequestOptions {
            return RequestOptions.placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background)
        }

        @Provides
        fun providesRequestManager(
            application: Application,
            requestOptions: RequestOptions
        ): RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions)
        }

        @Provides
        fun providesAppDrawable(application: Application): Drawable {
            return ContextCompat.getDrawable(application, R.drawable.ic_launcher_foreground)!!
        }
    }
}