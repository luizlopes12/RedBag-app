package com.example.kotlin_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var isDialogShown by mutableStateOf(false)
    private set

    fun showDialog(){
        isDialogShown = true
    }

    fun hideDialog(){
        isDialogShown = false
    }
}