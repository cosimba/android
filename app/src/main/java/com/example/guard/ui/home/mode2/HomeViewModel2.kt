package com.example.guard.ui.home.mode2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel2 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 2 home Fragment"
    }
    val text: LiveData<String> = _text
}