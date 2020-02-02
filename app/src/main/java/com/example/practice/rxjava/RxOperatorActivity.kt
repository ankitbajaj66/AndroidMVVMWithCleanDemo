package com.example.practice.rxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmvvmwithcleandemo.R
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

// This class shows diffrent operator
// 1. Just
// 2. fromArray
// 3. fromIterable
// 4. fromCallable
// 5. Range
// 6. Map
// 7. flatMap
// 8. concatMap
class RxOperatorActivity : AppCompatActivity() {

    companion object {
        val LOG: String = "RxOperatorActivity"
    }

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var justObservable: Observable<String>
    lateinit var justObserver: Observer<String>

    var list: Array<String> = arrayOf("ABC", "DDD")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_operator)

        /* // Just Operator simply returns items one at a time, if you pass array then it will return whole array once.
         justObservable = Observable.just("Hello", "RxJava")

         justObserver = object : Observer<String> {
             override fun onComplete() {
                 Log.i(LOG, "Normal Observeron onComplete")
             }

             override fun onSubscribe(d: Disposable?) {
                 Log.i(LOG, "NormalObserveron onSubscribe")
                 compositeDisposable.add(d)
             }

             override fun onNext(value: String?) {
                 Log.i(LOG, "NormalObserveron Next---" + value)
             }

             override fun onError(e: Throwable?) {
                 Log.i(LOG, "NormalObserveron onError" + e)
             }

         }
         justObservable.subscribe(justObserver)*/


        /* // fromIterable - iterate through the list and gives result one by one
         Observable.fromIterable(listOf<Int>(1, 2, 3)).subscribe({
             Log.i(LOG, "fromIterable : item" + it)
         }, {

         }, {

         }, {

         })

         // fromArray - takes argument as form of varag and return single item each time
         Observable.fromArray("1", "2", "3").subscribe {
             Log.i(LOG, "fromArray : item" + it)
         }


         *//* // Issue with just when Arithmatic exception
         Observable.just(getNumber()).subscribe({ result ->
             Log.i(LOG, "getNumber() result " + result)
         }, { error ->
             Log.i(LOG, "getNumber() result error" + error)
         })
 *//*

        // Solved Issue with from callable which executes lazily
        // Single method annonymosu inner class we can convert into lamda
        Observable.fromCallable<Int>(object : Callable<Int> {
            override fun call(): Int {
                return getNumber()
            }
        }).subscribe({
            Log.i(LOG, "getNumber() result " + it)
        }, {
            Log.i(LOG, "getNumber() result error" + it)
        })

        // Range operator
        Observable.range(1, 10).subscribe {
            Log.i(LOG, "range operator " + it)
        }

        // Create operator
        Observable.create<String>(object : ObservableOnSubscribe<String> {
            override fun subscribe(e: ObservableEmitter<String>?) {

                list.forEach {
                    e?.onNext(it)
                }

//                e?.onComplete()
            }
        }).subscribe {
            Log.i(LOG, "create operator " + it)
        }

        // Map Operator - transform the output
        Observable.just("a", "Bb", "cCc").map {
            it.toUpperCase()
        }.subscribe {
            Log.i(LOG, "Map operator " + it)
        }
*/


      /*  // FlatMap Operator - does not preserved the order
        Observable.range(1, 10).flatMap {
            return@flatMap getDataOnInput(it)
        }
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
                Log.i(LOG, "Flat Map operator " + it)
                //  Toast.makeText(this@RxOperatorActivity, it, Toast.LENGTH_LONG).show()
            }

        // ConcatMap Operator - preserved the order it wait for each observable to finish until start next obsevable
        Observable.range(100, 5).concatMap {
            return@concatMap getDataOnInput(it)

        } .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            Log.i(LOG, "ConcatMap operator " + it)
        }*/

        // debounce
        Observable.just(1, 1 ,1  ,3, 4).debounce(300 ,TimeUnit.MILLISECONDS)
            .subscribe {
                Log.i(LOG, "debounceoperator " + it)
            }

        // debou
        

    }

    fun getDataOnInput(input: Int): Observable<Int> {
        return Observable.just(input).delay(2, TimeUnit.SECONDS)

    }

    fun getNumber(): Int {
        Log.i(LOG, "getNumber() method called")
        return 1 / 0
    }

    // Test Method
    override fun onDestroy() {
        super.onDestroy()
    }
}
