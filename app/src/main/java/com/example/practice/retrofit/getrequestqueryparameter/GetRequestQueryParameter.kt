package com.example.practice.retrofit.getrequestqueryparameter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R
import com.example.practice.retrofit.getrequest.Post

import com.example.practice.retrofit.getrequest.PostApi
import kotlinx.android.synthetic.main.activity_get_request_query_parameter.retrofit_data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetRequestQueryParameter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_request_query_parameter)

        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val postApi = retrofit.create(PostApi::class.java)

        postApi.getPostsWithQueryString(2).enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if (!response.isSuccessful) {
                    retrofit_data.text = response.code().toString()
                    return
                }

                val postList: List<Post> = response.body()!!

                postList.forEach {
                    retrofit_data.append(it.toString() + "\n\n")
                }
            }
        })
    }
}
