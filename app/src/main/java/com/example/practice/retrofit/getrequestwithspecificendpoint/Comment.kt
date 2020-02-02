package com.example.practice.retrofit.getrequestwithspecificendpoint

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("postId") val postId: Int, val id: Int,
    val name: String,
    val email: String,
    val body: String
)
