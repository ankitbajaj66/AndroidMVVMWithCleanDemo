package com.example.androidmvvmwithcleandemo.post.presentation.di

import com.example.androidmvvmwithcleandemo.post.presentation.posts.PostsDetailsActivity
import dagger.Subcomponent

/**
 *Created by Ankit Bajaj on 16-02-2020.
 */
@Subcomponent(modules = [PostDetailsModule::class])
interface PostDetailsComponent {

    fun inject(postsDetailsActivity: PostsDetailsActivity)
}