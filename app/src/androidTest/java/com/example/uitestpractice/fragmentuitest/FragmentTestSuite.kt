package com.example.uitestpractice.fragmentuitest

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 *Created by Ankit Bajaj on 18-03-2020.
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieDetailFragmentTest::class, StarActorsFragmentTest::class, FragmentNavigationTest::class
)
class FragmentTestSuite {

}