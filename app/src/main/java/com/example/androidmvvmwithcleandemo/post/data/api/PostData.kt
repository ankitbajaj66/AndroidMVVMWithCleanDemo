package com.example.androidmvvmwithcleandemo.post.data.api

import com.google.gson.annotations.SerializedName

data class PostData(
    @SerializedName("userId")
    var userId: Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("body")
    var body: String
)