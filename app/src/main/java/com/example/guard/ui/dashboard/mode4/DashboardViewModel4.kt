// Mode4ViewModel.kt
package com.example.guard.ui.dashboard.mode4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Mode4ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 4 Fragment"
    }
    val text: LiveData<String> = _text
}