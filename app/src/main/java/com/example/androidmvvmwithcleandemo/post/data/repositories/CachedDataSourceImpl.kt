package com.example.androidmvvmwithcleandemo.post.data.repositories

import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable

class CachedDataSourceImpl : CachedDataSource {
    private val posts: LinkedHashMap<Int, PostEntity> = LinkedHashMap();

    override fun isEmpty(): Observable<Boolean> {
        return Observable.fromCallable {
            posts.isEmpty()
        }
    }

    override fun getPosts(): Observable<List<PostEntity>> {
        return Observable.just(posts.values.toList())
    }

    override fun saveAll(posts: List<PostEntity>) {
        posts.forEach { post ->
            this.posts[post.id] = post
        }
    }
}