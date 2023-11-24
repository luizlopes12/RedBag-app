package com.example.kotlin_app.utils

import com.example.kotlin_app.presentation.login.UserLoginRequestModel
import com.example.kotlin_app.presentation.login.UserLoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


public interface ApiService {
    @POST("/api/auth/login")
    suspend fun loginUser(@Body userLoginRequest: UserLoginRequestModel): Response<UserLoginResponseModel>
}