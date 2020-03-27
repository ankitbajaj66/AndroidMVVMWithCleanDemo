package com.example.practice.fragmentsdemo.fragmentfactorydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class HostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = CustomFragmentFactory("Hello Ankit")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        val bundle = Bundle()
        bundle.putString("args_test_data", "Hey")

//        savedInstanceState?.let {

        if(supportFragmentManager.fragments.size == 0) {
            supportFragmentManager.beginTransaction()
                .add(R.id.customFragment, FirstFragment::class.java, bundle)
                .commit()
//        }
        }
    }
}
