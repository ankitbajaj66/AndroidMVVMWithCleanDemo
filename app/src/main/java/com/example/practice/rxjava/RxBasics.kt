package com.example.practice.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidmvvmwithcleandemo.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rx_basics.*
import java.util.concurrent.TimeUnit

// This class contains very basic details
// 1. Observable
// 2. Observer
// 3. Disposable
// 4. DisposableObserver
// 5. CompositDisposable
class RxBasics : AppCompatActivity() {

    companion object {
        val LOG: String = "RxBasics"
    }


    lateinit var observable: Observable<String>
    lateinit var observer: Observer<String>
    lateinit var disposable: Disposable
    lateinit var disposableObserver: DisposableObserver<String>
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_basics)


        observable =
            Observable.just("Item1").delay(3, TimeUnit.SECONDS).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


        // Normal Observer which does not return Disposable
        observer = object : Observer<String> {
            override fun onComplete() {
                Log.i(LOG, "Normal Observeron onComplete")
                txt_data.setText("Normal Observeron Process Completed")
                //  Toast.makeText(this@RxBasics, "Emission completed", Toast.LENGTH_LONG).show()
            }

            override fun onSubscribe(d: Disposable?) {
                Log.i(LOG, "NormalObserveron onSubscribe")
//                disposable = d!!
                compositeDisposable.add(d)
            }

            override fun onNext(value: String?) {
                Log.i(LOG, "NormalObserveron Next---" + value)
            }

            override fun onError(e: Throwable?) {
                Log.i(LOG, "NormalObserveron onError" + e)
            }

        }

        // DisposableObserver which has methods of dispose
        disposableObserver = object : DisposableObserver<String>() {
            override fun onComplete() {
                Log.i(LOG, "DisposableObserver --- onComplete")
            }

            override fun onNext(value: String?) {
                Log.i(LOG, "DisposableObserver Next---" + value)
            }

            override fun onError(e: Throwable?) {
                Log.i(LOG, "DisposableObserver onError" + e)
            }

        }

        observable.subscribe(observer)
        observable.subscribe(disposableObserver)
        compositeDisposable.add(disposableObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        /* if (disposable.isDisposed) disposable.dispose()
         if (disposableObserver.isDisposed) disposable.dispose()*/

        if (compositeDisposable.isDisposed)
            compositeDisposable.clear()
    }
}
