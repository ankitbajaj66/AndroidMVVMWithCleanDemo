package com.example.androidmvvmwithcleandemo.post.domain.usecase

import com.example.androidmvvmwithcleandemo.post.domain.PostRepository
import com.example.androidmvvmwithcleandemo.post.domain.common.Transformer
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable

open class GetPosts(
    private val transformer: Transformer<List<PostEntity>>,
    private val repo: PostRepository
) : BaseUseCase<List<PostEntity>>(transformer) {
    override fun createObservable(withData: Map<String, Any>?): Observable<List<PostEntity>> {
        return repo.getPosts()
    }
}