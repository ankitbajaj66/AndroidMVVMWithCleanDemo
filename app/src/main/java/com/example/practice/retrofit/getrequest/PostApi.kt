package com.example.practice.retrofit.getrequest

import com.example.practice.retrofit.getrequestwithspecificendpoint.Comment
import retrofit2.Call
import retrofit2.http.*

interface PostApi {

    /**
     * 1. Simple end point
     *  https://jsonplaceholder.typicode.com/posts
     */
    @GET("posts")
    fun getPosts(): Call<List<Post>>


    /**
     * 2. End Point with filter using path, we can give multiple path variable
     * https://jsonplaceholder.typicode.com/posts/2/comments
     */
    @GET("posts/{id}/comments")
    fun getCommentsWithDynamicPath(@Path("id") id: Int): Call<List<Comment>>


    /**
     * 3. Using One Query parameter
     * https://jsonplaceholder.typicode.com/posts?userId=1
     */
    @GET("posts")
    fun getPostsWithQueryString(@Query("userId") userId: Int): Call<List<Post>>

    /**
     * 4. Using Multiple Query parameter
     * https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
     */
    @GET("posts")
    fun getPostsWithMultipleQueryString(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<List<Post>>

    /**
     * 5. Using Multiple Query parameter with repeated value
     * https://jsonplaceholder.typicode.com/posts?userId=1& userId=2&_sort=id&_order=desc
     */
    @GET("posts")
    fun getPostsWithMultipleQueryStringAndMultipleUserID(
        @Query("userId") userId1: Int,
        @Query("userId") userId2: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<List<Post>>

    /**
     * 6. Using Multiple Query parameter with repeated value - using vararg
     * https://jsonplaceholder.typicode.com/posts?userId=1& userId=2&_sort=id&_order=desc
     */
    @GET("posts")
    fun getPostsWithMultipleQueryStringAndMultipleUserID(
        @Query("_sort") sort: String,
        @Query("_order") order: String,
        @Query("userId") vararg userids: Int
    ): Call<List<Post>>


    /**
     * 7. Using Multiple Query parameter with repeated value - using array
     * https://jsonplaceholder.typicode.com/posts?userId=1& userId=2&_sort=id&_order=desc
     */
    @GET("posts")
    fun getPostsWithMultipleQueryStringAndMultipleUserIDWithArray(
        @Query("userId") list: Array<Int>,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<List<Post>>

    /**
     * 8. Using Multiple Query parameter with repeated value - using array
     * https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
     */
    @GET("posts")
    fun getPostsWithMultipleQueryStringUsingQueryMap(
        @QueryMap parameters: Map<String, String>
    ): Call<List<Post>>


    /**
     * 9. Using Multiple Query parameter with repeated value - using array
     * https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
     */
    @GET
    fun getPostsUsingUrl(
        @Url url: String
    ): Call<List<Post>>

    /**
     * 10. Direct url
     * https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
     */
    @GET("https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc")
    fun getPostsUsingFullUrl(
    ): Call<List<Post>>
}