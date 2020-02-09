package com.example.practice.dagger.daggersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R
import javax.inject.Inject

class TestInjectActivity : AppCompatActivity() {

    lateinit var carComponent: CarComponent
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_inject)

        carComponent = DaggerCarComponent.create()

        carComponent.inject(this)

//        carComponent.getCar()
    }
}
