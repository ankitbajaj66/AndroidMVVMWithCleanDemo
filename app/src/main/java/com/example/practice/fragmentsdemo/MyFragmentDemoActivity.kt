package com.example.practice.fragmentsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class MyFragmentDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_fragment_demo)

        // here we need to keep adding these lines
        // but incase of cnstructor we have choice to add different constructor call
//        val bundle = Bundle()
//        bundle.putString("argsText", "HelloFragment")
//        bundle.putInt("argsNumber", 123)

        val myTestFragment = MyTestFragment.newInstance("Hello Frag", 111)
//        myTestFragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.myframelayout, myTestFragment)
            .commit()
    }
}
