package com.example.androidmvvmwithcleandemo.testrx.schuedular

import io.reactivex.schedulers.Schedulers

class TrampolineSchedulerProvider : BaseSchedulerProvider {

    override fun computation() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}