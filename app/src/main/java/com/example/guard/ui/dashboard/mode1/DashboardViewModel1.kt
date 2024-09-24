// Mode1ViewModel.kt
package com.example.guard.ui.dashboard.mode1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Mode1ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mode 1 Fragment"
    }
    val text: LiveData<String> = _text
}
