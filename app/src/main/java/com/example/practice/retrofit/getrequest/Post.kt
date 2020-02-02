package com.example.practice.retrofit.getrequest

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId") val userId: Int, val id: Int? = null,
    val title: String,
    val body: String
) {
}