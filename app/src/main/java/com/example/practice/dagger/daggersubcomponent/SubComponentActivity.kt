package com.example.practice.dagger.daggersubcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class SubComponentActivity : AppCompatActivity() {

    lateinit var activityComponent8: PerActivityComponent8
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_component)

        activityComponent8 = (application as MyApplication8).perAppComponent8.getActivityComponent()

        var car8 = activityComponent8.getCar()
        car8.drive()
    }
}
