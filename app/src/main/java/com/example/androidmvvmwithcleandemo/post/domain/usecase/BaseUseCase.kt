package com.example.androidmvvmwithcleandemo.post.domain.usecase

import com.example.androidmvvmwithcleandemo.post.domain.common.Transformer
import com.example.androidmvvmwithcleandemo.post.domain.common.TransformerRx
import io.reactivex.Observable

abstract class BaseUseCase<T>(private val transformer: Transformer<T>) {

    abstract fun createObservable(withData: Map<String, Any>?): Observable<T>

    fun observable(withData: Map<String, Any>? = null): Observable<T> {
        return createObservable(withData).compose(transformer)
    }
}