package com.example.guard.ui.home.mode4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel4 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 4 home Fragment"
    }
    val text: LiveData<String> = _text
}