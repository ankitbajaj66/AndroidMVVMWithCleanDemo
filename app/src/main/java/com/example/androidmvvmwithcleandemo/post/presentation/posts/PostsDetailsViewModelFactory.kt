package com.example.androidmvvmwithcleandemo.post.presentation.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmwithcleandemo.post.domain.common.Mapper
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import com.example.androidmvvmwithcleandemo.post.domain.usecase.GetPosts
import com.example.androidmvvmwithcleandemo.post.presentation.entities.Post

class PostsDetailsViewModelFactory(
    private val getPosts: GetPosts,
    private val mapper: Mapper<PostEntity, Post>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsDetailsViewModel(getPosts, mapper) as T
    }
}