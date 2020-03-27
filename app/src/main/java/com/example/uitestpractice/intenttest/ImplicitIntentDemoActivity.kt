package com.example.uitestpractice.intenttest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.bumptech.glide.Glide
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.activity_implicit_intent_demo.*

const val GALARY_REQUEST_CODE = 1;

class ImplicitIntentDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent_demo)

        btn_get_image_from_gallary.setOnClickListener {
            pickFromGallary()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            Log.d("ImplicitIntent", "Result Ok")

            when (requestCode) {
                GALARY_REQUEST_CODE -> {
                    Log.d("ImplicitIntent", "Request Code Detected ::::: ${data?.data}")

                    data?.data?.let { uri ->
                        Log.d("ImplicitIntent", "Image Uri:$uri")
                        Glide.with(this).load(uri).into(img_view)

                    }
                }
            }
        }
    }

    private fun pickFromGallary() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALARY_REQUEST_CODE)
    }
}
