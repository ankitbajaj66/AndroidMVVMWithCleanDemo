package com.example.androidmvvmwithcleandemo.post.presentation.di

import com.example.androidmvvmwithcleandemo.post.data.repositories.PostRepositoryImpl
import com.example.androidmvvmwithcleandemo.post.domain.PostRepository
import com.example.androidmvvmwithcleandemo.post.domain.usecase.GetPostsUseCase
import com.example.androidmvvmwithcleandemo.post.presentation.common.AsyncTransformer
import com.example.androidmvvmwithcleandemo.post.presentation.mappers.PostEntityPostMapper
import com.example.androidmvvmwithcleandemo.post.presentation.posts.PostsDetailsViewModelFactory
import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 16-02-2020.
 */
@Module
class PostDetailsModule {

    @Provides
    fun getPostDetailsUseCase(postRepository: PostRepository): GetPostsUseCase {
        return GetPostsUseCase(AsyncTransformer(), postRepository)
    }

    @Provides
    fun getPostDetailsVMFactory(
        useCase: GetPostsUseCase,
        mapper: PostEntityPostMapper
    ): PostsDetailsViewModelFactory {
        return PostsDetailsViewModelFactory(useCase, mapper)
    }
}