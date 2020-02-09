package com.example.practice.dagger.interfacedependancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class InterfaceDepActivity : AppCompatActivity() {

    lateinit var car2: Car2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface_dep)

        val carComponentInterfaceDep = DaggerCarComponentInterfaceDep.create()
        car2 = carComponentInterfaceDep.getCar()

        car2.ready()

    }
}
