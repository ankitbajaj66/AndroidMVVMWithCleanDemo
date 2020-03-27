package com.example.practice.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.activity_service_demo.*

class ServiceDemoActivity : AppCompatActivity() {


    lateinit var myServiceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_demo)

        Log.i("ServiceDemoActivity", "Thread name " + Thread.currentThread().name)
        myServiceIntent = Intent(this, MyService::class.java)

        btn_start_service.setOnClickListener {
            startService(myServiceIntent);
        }

        btn_stop_service.setOnClickListener {
            stopService(myServiceIntent)
        }

    }
}
