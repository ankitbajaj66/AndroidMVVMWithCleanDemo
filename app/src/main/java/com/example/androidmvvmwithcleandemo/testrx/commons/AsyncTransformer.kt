package com.example.androidmvvmwithcleandemo.testrx.commons

import com.example.androidmvvmwithcleandemo.post.domain.common.Transformer
import com.example.androidmvvmwithcleandemo.post.domain.common.TransformerRx
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AsyncTransformerRx<T> : TransformerRx<T>() {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}