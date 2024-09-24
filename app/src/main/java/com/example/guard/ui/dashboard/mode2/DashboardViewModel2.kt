// Mode2ViewModel.kt
package com.example.guard.ui.dashboard.mode2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Mode2ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 2 Fragment"
    }
    val text: LiveData<String> = _text
}