package com.example.kotlin_app.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.File

class FileViewModel(
    private val repository: FileRepository = FileRepository()
) : ViewModel() {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @RequiresApi(Build.VERSION_CODES.S)
    fun uploadImage(file: File, onUploadResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.uploadImage(file)
            onUploadResult(result)

            // Log the response to the console
            if (result) {
                println("Upload successful!")
            } else {
                println("Upload failed.")
            }
        }
    }
}
