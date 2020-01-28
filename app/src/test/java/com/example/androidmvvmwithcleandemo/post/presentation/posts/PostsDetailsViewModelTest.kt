package com.example.androidmvvmwithcleandemo.post.presentation.posts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.androidmvvmwithcleandemo.post.domain.PostRepository
import com.example.androidmvvmwithcleandemo.post.domain.common.TestTransformer
import com.example.androidmvvmwithcleandemo.post.domain.common.TestTransformerRx
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import com.example.androidmvvmwithcleandemo.post.domain.usecase.GetPosts
import com.example.androidmvvmwithcleandemo.post.presentation.mappers.PostEntityPostMapper
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
/*@PrepareForTest(Validator::class)*/
class PostsDetailsViewModelTest {

    private val postEntityPostMapper = PostEntityPostMapper()
    private lateinit var postsDetailsViewModel: PostsDetailsViewModel

    val username = "ankitbajaj1989@gmail.com"
    val password = "12345"

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var postRepository: PostRepository

    @Mock
    private lateinit var observer: Observer<PostsViewState>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val getPopularMoviesUseCase = GetPosts(TestTransformer(), postRepository)

        postsDetailsViewModel = PostsDetailsViewModel(getPopularMoviesUseCase, postEntityPostMapper)
        postsDetailsViewModel.viewState.observeForever(observer)
/*
        PowerMockito.mockStatic(Validator::class.java)
        Mockito.`when`(Validator.isUserNameValid(username)).thenReturn(true)
        Mockito.`when`(Validator.isPasswordValid(username)).thenReturn(true)*/
    }

    @Test
    fun testInitialViewStateShowsLoading() {
        Mockito.verify(observer)
            .onChanged(PostsViewState(isLoading = true, isEmpty = true, posts = null))
        Mockito.verifyZeroInteractions(observer)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun TestValidUserNameAndPassValidWithSuccess() {

        val postEntity = generatePostEntityList()

        Mockito.`when`(postRepository.getPosts()).thenReturn(Observable.just(postEntity))

        val posts = postEntity.map { postEntityPostMapper.mapFrom(it) }
        postsDetailsViewModel.onLoginClicked(username, password)
        Mockito.verify(observer)
            .onChanged(PostsViewState(isLoading = false, isEmpty = false, posts = posts))
    }

    @Test
    fun TestValidUserNameAndPassValidWithFail() {
        val username = "ankitbajaj1989@gmail.com"
        val password = "12345"
        val throwable = Throwable("ERROR!")
        Mockito.`when`(postRepository.getPosts()).thenReturn(Observable.error(throwable))

        postsDetailsViewModel.onLoginClicked(username, password)
        Mockito.verify(observer)
            .onChanged(PostsViewState(isLoading = false, isEmpty = true, posts = null))
    }

    fun generatePostEntityList(): List<PostEntity> {
        return (0..4).map { getTestPostEntity(it) }
    }

    fun getTestPostEntity(id: Int): PostEntity {
        return PostEntity(
            id = id,
            title = "Post$id",
            body = "PostBody$id",
            userId = id
        )
    }
}