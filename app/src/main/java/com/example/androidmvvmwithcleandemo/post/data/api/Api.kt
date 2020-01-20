package com.example.androidmvvmwithcleandemo.post.data.api

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("https://jsonplaceholder.typicode.com/posts")
    fun getPosts() : Observable<List<PostData>>
}