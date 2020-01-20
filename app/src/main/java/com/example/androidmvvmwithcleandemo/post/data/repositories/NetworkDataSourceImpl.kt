package com.example.androidmvvmwithcleandemo.post.data.repositories

import com.example.androidmvvmwithcleandemo.post.data.api.Api
import com.example.androidmvvmwithcleandemo.post.data.mappers.PostDataEntityMapper
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable

class NetworkDataSourceImpl(
    private val api: Api,
    private val postDataEntityMapper: PostDataEntityMapper
) : NetworkDataSource {
    override fun getPosts(): Observable<List<PostEntity>> {
        return api.getPosts().map {
            it.map {
                postDataEntityMapper.mapFrom(it)
            }
        }
    }
}