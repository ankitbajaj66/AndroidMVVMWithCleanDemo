package com.example.practice.retrofit.getrequestwithspecificendpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R
import com.example.practice.retrofit.getrequest.PostApi
import kotlinx.android.synthetic.main.activity_retrofit_get_request.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGetRequestWithSpecificEndPointActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_get_request_with_specific_end_point)

        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val postApi = retrofit.create(PostApi::class.java)

        postApi.getCommentsWithDynamicPath(1).enqueue(object : Callback<List<Comment>> {
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                // IF something went wrong in processing the url , some typo error in base url
                // any parsing error
                // someting wrong in communicating to server
                retrofit_data.text = t.message
            }

            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                // Even in success response we can get diff codes - 404, 407, 200
                //retrofit_data.text = response.code().toString()

                if (!response.isSuccessful) {
                    retrofit_data.text = response.code().toString()
                    return
                }

                var listPost: List<Comment>? = response.body()

                println("Data from Server")
                listPost?.forEach { comment ->
                    println(comment)
                    retrofit_data.append(comment.toString() + "\n\n")
                }

            }

        })
    }
}
