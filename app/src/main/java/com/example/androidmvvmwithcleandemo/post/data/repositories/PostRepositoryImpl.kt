package com.example.androidmvvmwithcleandemo.post.data.repositories

import com.example.androidmvvmwithcleandemo.post.domain.PostRepository
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable

class PostRepositoryImpl constructor(
    private val networkDataStore: NetworkDataSource,
    private val cachedDataStore: CachedDataSource
) :
    PostRepository {


    /*companion object {

        fun clear() {
            instance = null
        }

        @Volatile
        private var instance: PostRepositoryImpl? = null

        fun newInstance(networkDataStore: NetworkDataSource, cachedDataStore: CachedDataSource) =
            instance ?: synchronized(this) {
                instance ?: PostRepositoryImpl(networkDataStore, cachedDataStore).also {
                    instance = it
                }
            }
    }*/

    override fun getPosts(): Observable<List<PostEntity>> {

        return cachedDataStore.isEmpty().flatMap { isEmpty ->
            if (!isEmpty)
                return@flatMap cachedDataStore.getPosts()
            else
                return@flatMap networkDataStore.getPosts().doOnNext { posts ->
                    cachedDataStore.saveAll(posts)
                }
        }
    }

}