package com.example.guard.ui.home.mode3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel3 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 3 home Fragment"
    }
    val text: LiveData<String> = _text
}