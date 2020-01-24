package com.example.androidmvvmwithcleandemo.post.data.repositories

import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import io.reactivex.Observable
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostRepositoryImplTest {

    @Mock
    private lateinit var networkDataSource: NetworkDataSource

    @Mock
    private lateinit var cachedDataSource: CachedDataSource

    private lateinit var repositoryImpl: PostRepositoryImpl

    @Before
    fun setUp() {
        repositoryImpl = PostRepositoryImpl.getInstance(networkDataSource, cachedDataSource)
    }

    @After
    fun tearDown() {
        PostRepositoryImpl.clear()
    }

    @Test
    fun getPostsWhenCacheISEmpty() {
        `when`(cachedDataSource.isEmpty()).thenReturn(Observable.just(true))
        `when`(networkDataSource.getPosts()).thenReturn(Observable.just(generatePostDataList()))
        repositoryImpl.getPosts().test().assertComplete().assertValue { posts ->
            posts.size == 5
        }
    }

    @Test
    fun getPostsWhenCacheIsNotEmpty() {
        `when`(cachedDataSource.isEmpty()).thenReturn(Observable.just(false))
        `when`(cachedDataSource.getPosts()).thenReturn(Observable.just(generatePostDataList()))
        repositoryImpl.getPosts().test().assertComplete().assertValue { posts ->
            posts.size == 5
        }
    }
    fun generatePostDataList(): List<PostEntity> {

        return (0..4).map {
            PostEntity(
                id = it,
                title = "Post$it",
                body = "PostBOdy$it",
                userId = it
            )
        }
    }
}