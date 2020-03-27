package com.example.uitestpractice

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.androidmvvmwithcleandemo.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.EnumSet.allOf


/**
 * Created by Ankit Bajaj on 15-03-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class FirstUiTestActivityTest {

//    @JvmField
//    @Rule
//    var activityTestRule: ActivityTestRule<FirstUiTestActivity> =
//        ActivityTestRule(FirstUiTestActivity::class.java)

    @get : Rule
    val activityScenario : ActivityScenarioRule<FirstUiTestActivity> = ActivityScenarioRule(FirstUiTestActivity::class.java)

    @Test
    fun testViewTextUsingData() {
        onView(withText("Hello")).check(matches(isDisplayed()))
    }

    @Test
    fun testViewTextUsingView() {
        onView(withId(R.id.txt_data)).check(matches(isDisplayed()))
    }

    @Test
    fun testViewTextUsingContentDes() {
        onView(withContentDescription("aaa")).check(matches(isDisplayed()))
    }

    @Test
    fun testViewTextUsingHint() {
        onView(withHint("EnterName")).check(matches(isDisplayed()))
    }

    @Test
    fun testViewTextUsingWithSpinnerText() {
        val viewInteraction = onView(withSpinnerText("3"))
        viewInteraction.check(matches(isDisplayed()))
    }

    @Test
    fun testViewTextUsingWithLinks() {
        val viewInteraction = onView(hasLinks())
        viewInteraction.check(matches(isDisplayed()))
    }

    @Test
    fun testViewTextUsingWithStringinMatches() {
        onView(withId(R.id.txt_data)).check(matches(withText("Hello")))
    }
}