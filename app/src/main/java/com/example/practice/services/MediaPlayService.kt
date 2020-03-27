package com.example.practice.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.example.androidmvvmwithcleandemo.R

/**
 *Created by Ankit Bajaj on 06-03-2020.
 */
class MediaPlayService : Service() {

    lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mediaPlayer = MediaPlayer.create(this, R.raw.tera_chehra)
        mediaPlayer.start()
        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        super.onDestroy()
    }
}