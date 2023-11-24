package com.example.kotlin_app.presentation.login

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body

data class UserLoginRequestModel(
    @SerializedName("usernameOrEmail") val email: String,
    @SerializedName("password") val password: String
)
data class UserLoginResponseModel(
    @SerializedName("token") val token: String
)