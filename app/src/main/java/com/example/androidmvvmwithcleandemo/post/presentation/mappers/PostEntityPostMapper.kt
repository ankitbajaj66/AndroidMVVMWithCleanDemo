package com.example.androidmvvmwithcleandemo.post.presentation.mappers

import com.example.androidmvvmwithcleandemo.post.data.api.PostData
import com.example.androidmvvmwithcleandemo.post.domain.common.Mapper
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import com.example.androidmvvmwithcleandemo.post.presentation.entities.Post

class PostEntityPostMapper : Mapper<PostEntity, Post>() {
    override fun mapFrom(from: PostEntity): Post {
        return Post(
            userId = from.userId,
            id = from.id,
            title = from.title,
            body = from.body
        )
    }
}