package com.example.uitestpractice.intenttest

import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.app.Instrumentation.*
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.activity_implicit_intent_demo.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ankit Bajaj on 18-03-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ImplicitIntentDemoActivityTest {

    @get : Rule
    val intentTestRule = IntentsTestRule(ImplicitIntentDemoActivity::class.java)

    @Test
    fun validateIntentForPictureCapture() {

        // Given
        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )

        val activityResult = createGallaryPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult)

        // Execute and Verify
        onView(withId(R.id.btn_get_image_from_gallary)).perform(click())
        intended(expectedIntent)
    }

    private fun createGallaryPickActivityResultStub(): ActivityResult {
        val resources: Resources = InstrumentationRegistry.getInstrumentation().context.resources
        val imageUrl = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                    resources.getResourcePackageName(R.drawable.ic_launcher_foreground) + "/" +
                    resources.getResourceTypeName(R.drawable.ic_launcher_foreground) + "/" +
                    resources.getResourceEntryName(R.drawable.ic_launcher_foreground)
        )

        val resultIntent = Intent()
        resultIntent.data = imageUrl

        return ActivityResult(RESULT_OK, resultIntent)
    }
}