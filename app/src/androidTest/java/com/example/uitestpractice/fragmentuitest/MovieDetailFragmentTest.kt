package com.example.uitestpractice.fragmentuitest

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.androidmvvmwithcleandemo.R
import com.example.uitestpractice.fragmentuitest.data.DummyMovies
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ankit Bajaj on 17-03-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest {

    @Test
    fun isMovieDataVisible() {
        val movie = DummyMovies.THE_RUNDOWN
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)

        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.detail_container)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))

    }
}
