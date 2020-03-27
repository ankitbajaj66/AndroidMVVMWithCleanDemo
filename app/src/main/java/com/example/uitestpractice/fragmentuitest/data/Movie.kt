package com.example.uitestpractice.fragmentuitest.data

/**
 *Created by Ankit Bajaj on 17-03-2020.
 */

data class Movie (
    val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val directors: ArrayList<String>?,
    val star_actors: ArrayList<String>?
)