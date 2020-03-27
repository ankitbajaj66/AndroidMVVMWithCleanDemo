package com.example.uitestpractice

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 *Created by Ankit Bajaj on 16-03-2020.
 */
@RunWith(Suite::class)
@Suite.SuiteClasses
    (
    FirstActivityTest::class,
    SecondActivityTest::class
    )
class ActivityTestSuite

