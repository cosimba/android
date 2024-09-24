// Mode3ViewModel.kt
package com.example.guard.ui.dashboard.mode3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Mode3ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 3 Fragment"
    }
    val text: LiveData<String> = _text
}