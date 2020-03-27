package com.example.uitestpractice.fragmentuitest

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.androidmvvmwithcleandemo.R
import com.example.uitestpractice.fragmentuitest.data.DummyMovies
import kotlinx.android.synthetic.main.fragment_star_actors.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ankit Bajaj on 17-03-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest {


    @Test
    fun test_star_actors_visible() {

        val movie = DummyMovies.INFINITY_WAR
        val directors = arrayListOf("Robert Downey Jr.", "Chris Hemsworth", "Mark Ruffalo", "+ more...")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", movie.star_actors)

        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

//        onView(withId(R.id.star_detail_container)).check(matches(isDisplayed()))
        onView(withId(R.id.star_detail_container)).check(matches(isDisplayed()))
        onView(withId(R.id.star_actors_title)).check(matches(isDisplayed()))
        onView(withId(R.id.star_actors_text)).check(matches(isDisplayed()))
        onView(withId(R.id.star_actors_text)).check(matches(withText(
            StarActorsFragment.stringBuilderForStarActors(
                directors
            )
        )))



    }
}