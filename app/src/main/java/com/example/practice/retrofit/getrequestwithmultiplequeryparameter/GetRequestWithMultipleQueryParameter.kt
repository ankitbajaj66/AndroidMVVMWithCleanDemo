package com.example.practice.retrofit.getrequestwithmultiplequeryparameter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R
import com.example.practice.retrofit.getrequest.Post

import com.example.practice.retrofit.getrequest.PostApi
import kotlinx.android.synthetic.main.activity_get_request_query_parameter.*
import kotlinx.android.synthetic.main.activity_retrofit_get_request.*
import kotlinx.android.synthetic.main.activity_retrofit_get_request.retrofit_data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetRequestWithMultipleQueryParameter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_request_with_multiple_query_parameter)

        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val postApi = retrofit.create(PostApi::class.java)

        /*postApi.getPostsWithMultipleQueryStringAndMultipleUserID(1, 2, "id", "desc")
            .enqueue(object : Callback<List<Post>> {
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    // IF something went wrong in processing the url , some typo error in base url
                    // any parsing error
                    // someting wrong in communicating to server
                    retrofit_data.text = t.message
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
            })*/

        /*  // https://jsonplaceholder.typicode.com/posts?userId=1&userId=2&_sort=id&_order=desc
          postApi.getPostsWithMultipleQueryStringAndMultipleUserIDWithArray(arrayOf(1, 2),"id", "desc")
              .enqueue(object : Callback<List<Post>> {
                  override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                      // IF something went wrong in processing the url , some typo error in base url
                      // any parsing error
                      // someting wrong in communicating to server
                      retrofit_data.text = t.message
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
              })*/

        // https://jsonplaceholder.typicode.com/posts?userId=1&userId=2&_sort=id&_order=desc
        val map = HashMap<String, String>()
        map.put("userId", "1")
        map.put("_sort", "id")
        map.put("_order", "desc")

        postApi.getPostsWithMultipleQueryStringUsingQueryMap(map)
            .enqueue(object : Callback<List<Post>> {
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    // IF something went wrong in processing the url , some typo error in base url
                    // any parsing error
                    // someting wrong in communicating to server
                    retrofit_data.text = t.message
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
