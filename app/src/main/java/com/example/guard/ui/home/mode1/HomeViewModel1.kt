package com.example.guard.ui.home.mode1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel1 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 1 home Fragment"
    }
    val text: LiveData<String> = _text
}