package com.example.androidmvvmwithcleandemo.post.presentation.posts

import androidx.lifecycle.MutableLiveData
import com.example.androidmvvmwithcleandemo.post.common.utils.Validator
import com.example.androidmvvmwithcleandemo.post.domain.common.Mapper
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import com.example.androidmvvmwithcleandemo.post.domain.usecase.GetPostsUseCase
import com.example.androidmvvmwithcleandemo.post.presentation.common.BaseViewModel
import com.example.androidmvvmwithcleandemo.post.presentation.entities.Post

class PostsDetailsViewModel(
    private val getPosts: GetPostsUseCase,
    private val postMapper: Mapper<PostEntity, Post>
) : BaseViewModel() {

    var viewState: MutableLiveData<PostsViewState> = MutableLiveData()

    init {
        val viewState = PostsViewState()
        this.viewState.value = viewState
    }

    fun getPosts() {
        addDisposable(getPosts.observable().flatMap {
            postMapper.observable(it)
        }.subscribe({ posts ->

            val newViewState = viewState.value?.copy(
                isLoading = false,
                isEmpty = false,
                posts = posts
            )
            viewState.value = newViewState

        }, {
            val newViewState = viewState.value?.copy(
                isLoading = false,
                isEmpty = true,
                posts = null
            )
            viewState.value = newViewState
        }))
    }

    fun onLoginClicked(username: String, password: String) {
        if (Validator.isUserNameValid(username) && Validator.isPasswordValid(password)) {
            getPosts()
        }
    }

}