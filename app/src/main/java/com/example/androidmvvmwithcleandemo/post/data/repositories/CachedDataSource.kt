package com.example.androidmvvmwithcleandemo.post.data.repositories

import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable

interface CachedDataSource {
    fun getPosts(): Observable<List<PostEntity>>
    fun isEmpty(): Observable<Boolean>
    fun saveAll(posts: List<PostEntity>)
}