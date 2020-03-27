package com.example.uitestpractice.fragmentuitest.data.source

import com.example.uitestpractice.fragmentuitest.data.DummyMovies.INFINITY_WAR
import com.example.uitestpractice.fragmentuitest.data.DummyMovies.THE_RUNDOWN
import com.example.uitestpractice.fragmentuitest.data.Movie

/**
 *Created by Ankit Bajaj on 17-03-2020.
 */
object MoviesRemoteDataSource: MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(2)

    init {
        addMovie(INFINITY_WAR)
        addMovie(THE_RUNDOWN)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(movie: Movie){
        MOVIES_REMOTE_DATA.put(movie.id, movie)
    }


}