package com.example.androidmvvmwithcleandemo.post.presentation.posts

import androidx.lifecycle.Observer
import com.example.androidmvvmwithcleandemo.post.domain.usecase.GetPosts
import com.example.androidmvvmwithcleandemo.post.presentation.mappers.PostEntityPostMapper
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule


@Suppress("DEPRECATION")
@RunWith(MockitoJUnitRunner::class)
class PostsDetailsViewModelTest {

    private val postEntityPostMapper = PostEntityPostMapper()
    private lateinit var postsDetailsViewModel: PostsDetailsViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getPosts: GetPosts

    @Mock
    private lateinit var observer: Observer<PostsViewState>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        postsDetailsViewModel = PostsDetailsViewModel(getPosts, postEntityPostMapper)
        postsDetailsViewModel.viewState.observeForever(observer)
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
    fun getPosts() {
    }
}