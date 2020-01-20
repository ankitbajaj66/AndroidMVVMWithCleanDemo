package com.example.androidmvvmwithcleandemo.post.domain

import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable

interface PostRepository {
    fun getPosts(): Observable<List<PostEntity>>
}