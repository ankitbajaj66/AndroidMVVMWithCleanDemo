package com.example.practice.retrofit.getrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.activity_retrofit_get_request.*
import kotlinx.android.synthetic.main.activity_rx_basics.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGetRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_get_request)

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        val retrofit =
            Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        val postApi = retrofit.create(PostApi::class.java)

        /* postApi.getPosts().enqueue(object : Callback<List<Post>> {
             override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                 // IF something went wrong in processing the url , some typo error in base url
                 // any parsing error
                 // someting wrong in communicating to server
                 retrofit_data.text = t.message
             }

             override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                 // Even in success response we can get diff codes - 404, 407, 200
                 //retrofit_data.text = response.code().toString()

                 if (!response.isSuccessful) {
                     retrofit_data.text = response.code().toString()
                     return
                 }

                 var listPost: List<Post>? = response.body()

                 println("Data from Server")
                 listPost?.forEach { post ->
                     println(post)
                     retrofit_data.append(post.toString()+"\n\n")
                 }
             }
         })*/

        postApi.getPostsUsingUrl("https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc")
            .enqueue(object : Callback<List<Post>> {
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    // IF something went wrong in processing the url , some typo error in base url
                    // any parsing error
                    // someting wrong in communicating to server
                    retrofit_data.text = t.message
                }

                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    // Even in success response we can get diff codes - 404, 407, 200
                    //retrofit_data.text = response.code().toString()

                    if (!response.isSuccessful) {
                        retrofit_data.text = response.code().toString()
                        return
                    }

                    var listPost: List<Post>? = response.body()

                    println("Data from Server")
                    listPost?.forEach { post ->
                        println(post)
                        retrofit_data.append(post.toString() + "\n\n")
                    }
                }
            })
    }
}
