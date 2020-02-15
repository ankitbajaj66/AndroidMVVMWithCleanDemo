package com.example.practice.dagger.subcomponentwithbuilder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class SubComponentBuilderActivity : AppCompatActivity() {

    lateinit var perActivityComponent9: PerActivityComponent9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_component_builder)

        perActivityComponent9 =
            (application as MyApplication9).perAppComponent9.getActivityComponentBuilder().engineCapacity(100).build()

        perActivityComponent9.getCar().drive()
    }
}
