package com.example.uitestpractice


import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule

import com.example.androidmvvmwithcleandemo.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
/**
 * Created by Ankit Bajaj on 16-03-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class FirstActivityTest {

    @get : Rule
    val activityScenarioRule = ActivityScenarioRule(FirstActivity::class.java)

    @Test
    fun testRootLayoutVissibility() {
        onView(withId(R.id.container_first_screen)).check(matches(isDisplayed()))
    }

    @Test
    fun testOtherViewsVisibility() {
        onView(withId(R.id.textView)).check(matches(isDisplayed())) // method 1 to test visibility
        onView(withId(R.id.btn_Next)).check(matches(withEffectiveVisibility(Visibility.VISIBLE))) // method 2 to test visibility
    }

    @Test
    fun testTextIsDisplayedCorrectly() {
        onView(withId(R.id.textView)).check(matches(withText("First Activity")))
        onView(withId(R.id.btn_Next)).check(matches(withText(R.string.next)))
    }

    @Test
    fun testNavSecondaryActivity() {
        onView(withId(R.id.btn_Next)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.container_second_screen))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testNavPrimaryActivity() {
//        val activityScenario = ActivityScenario.launch(SecondActivity::class.java)

        onView(withId(R.id.btn_Next)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.container_second_screen))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        onView(withId(R.id.btn_previous)).perform(click())// method 1
        pressBack()
        onView(withId(R.id.container_first_screen)).check(matches(isDisplayed()))
    }
}