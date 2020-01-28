package com.example.androidmvvmwithcleandemo.post.domain.common

import io.reactivex.Observable
import io.reactivex.ObservableSource

/**
 * Created by Yossi Segev on 13/11/2017.
 */
class TestTransformerRx<T>: TransformerRx<T>() {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
    }

}