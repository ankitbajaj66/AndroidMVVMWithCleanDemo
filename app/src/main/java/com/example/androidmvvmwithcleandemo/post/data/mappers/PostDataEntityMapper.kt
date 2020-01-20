package com.example.androidmvvmwithcleandemo.post.data.mappers

import com.example.androidmvvmwithcleandemo.post.data.api.PostData
import com.example.androidmvvmwithcleandemo.post.domain.common.Mapper
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity

class PostDataEntityMapper : Mapper<PostData, PostEntity>() {
    override fun mapFrom(from: PostData): PostEntity {
        return PostEntity(
            userId = from.userId,
            id = from.id,
            title = from.title,
            body = from.body
        )
    }
}