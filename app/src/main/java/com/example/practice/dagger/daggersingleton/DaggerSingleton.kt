package com.example.practice.dagger.daggersingleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class DaggerSingleton : AppCompatActivity() {

    lateinit var car7: Car7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_singleton)

        car7 = DaggerActivityComponent.builder()
            .appComponent((application as MyApplication).appComponent).build().getCar()

        car7.drive()
    }
}
