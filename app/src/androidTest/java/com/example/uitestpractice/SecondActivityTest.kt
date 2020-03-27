package com.example.uitestpractice

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.androidmvvmwithcleandemo.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ankit Bajaj on 16-03-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest
{
    @get : Rule
    val activityScenarioRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun testRootLayoutVissibility() {
        Espresso.onView(ViewMatchers.withId(R.id.container_second_screen))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testOtherViewsVisibility() {
        Espresso.onView(ViewMatchers.withId(R.id.txt_second_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // method 1 to test visibility
        Espresso.onView(ViewMatchers.withId(R.id.btn_previous))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))) // method 2 to test visibility
    }

    @Test
    fun testTextIsDisplayedCorrectly() {
        Espresso.onView(ViewMatchers.withId(R.id.txt_second_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Second Activity")))
        Espresso.onView(ViewMatchers.withId(R.id.btn_previous))
            .check(ViewAssertions.matches(ViewMatchers.withText("Previous")))
    }
}