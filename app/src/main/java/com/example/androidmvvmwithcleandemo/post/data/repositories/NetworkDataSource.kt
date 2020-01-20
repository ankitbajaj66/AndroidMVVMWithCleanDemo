package com.example.androidmvvmwithcleandemo.post.data.repositories

import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable

interface NetworkDataSource {
    fun getPosts(): Observable<List<PostEntity>>
}