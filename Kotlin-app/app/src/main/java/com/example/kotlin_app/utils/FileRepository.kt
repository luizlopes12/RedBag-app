package com.example.kotlin_app.utils

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.IOException

class FileRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun uploadImage(file: File): Boolean{
        return try {
            FileApi.instance.uploadImage(
                file = MultipartBody.Part.createFormData(
                    "file",
                    file.name,
                    file.asRequestBody()
                )
            )
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        } catch (e: HttpException) {
            print("Deu ruim no HTTP")
            e.printStackTrace()
            false
        }
    }
}