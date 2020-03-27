package com.example.uitestpractice.fragmentuitest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 *Created by Ankit Bajaj on 18-03-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentNavigationTest {


    @Test
    fun testMovieFragmentNavigation() {

        // Setup
        val activityScenario = ActivityScenario.launch(MainFragmentContainerActivity::class.java)

        // Nav to First Fragment

        // Test Activity Root Layout
        onView(withId(R.id.container)).check(matches(isDisplayed()))

        // Test First Default Fragment root layout
        onView(withId(R.id.detail_container)).check(matches(isDisplayed()))

        // Perform Click
        onView(withId(R.id.movie_star_actors)).perform(click())

        // Verify New Fragment root layout
        onView(withId(R.id.star_detail_container)).check(matches(isDisplayed()))

    }
}