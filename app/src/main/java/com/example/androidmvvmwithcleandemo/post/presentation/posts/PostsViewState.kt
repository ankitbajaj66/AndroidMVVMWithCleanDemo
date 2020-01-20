package com.example.androidmvvmwithcleandemo.post.presentation.posts

import com.example.androidmvvmwithcleandemo.post.presentation.entities.Post

data class PostsViewState(
    val isLoading: Boolean = true,
    val isEmpty: Boolean = true,
    val posts: List<Post>? = null
) {

}