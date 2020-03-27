package com.example.practice.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 *Created by Ankit Bajaj on 01-03-2020.
 */
class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        Log.i("MyService", "onDestroy ---- Thread name " + Thread.currentThread().name)
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("MyService", "onStartCommand---- Thread name " + Thread.currentThread().name)
        return START_REDELIVER_INTENT
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("MyService", "onCreate ---- Thread name " + Thread.currentThread().name)
    }
}