package com.example.practice.sealedclass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *Created by Ankit Bajaj on 17-02-2020.
 */
class SealedClassViewModel : ViewModel() {

    private val _state: MutableLiveData<State> = MutableLiveData<State>()
    val state: LiveData<State> = _state

    sealed class State {
        data class One(val data1: String) : State()
        data class Two(val data2: String) : State()
        data class Three(val data3: String) : State()
    }

    fun fetchFirstThreeStates() {
        _state.value = State.One("One")
        _state.value = State.Two("Two")
        _state.value = State.Three("Three")

    }
}

