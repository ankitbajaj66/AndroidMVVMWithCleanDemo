package com.example.uitestpractice.fragmentuitest.data.source

import com.example.uitestpractice.fragmentuitest.data.Movie

/**
 *Created by Ankit Bajaj on 17-03-2020.
 */


interface MoviesDataSource {
    fun getMovie(movieId: Int): Movie?
}