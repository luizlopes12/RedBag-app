package com.example.kotlin_app.utils

import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FileApi {
    @Multipart
    @POST("/predict")
    suspend fun uploadImage(
        @Part file: MultipartBody.Part
    )

    companion object {
        val instance by lazy {
            Retrofit.Builder()
                .baseUrl("https://red-bag-api-distroless.onrender.com")
                .build()
                .create(FileApi::class.java)
        }
    }
}