package com.example.androidmvvmwithcleandemo.post.domain.common

import io.reactivex.Observable
import io.reactivex.ObservableTransformer

abstract class Transformer<T> : ObservableTransformer<T, T> {

}