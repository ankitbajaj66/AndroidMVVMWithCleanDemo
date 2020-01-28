package com.example.androidmvvmwithcleandemo.testrx.schuedular

import io.reactivex.Scheduler

interface BaseSchedulerProvider {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun ui(): Scheduler
}