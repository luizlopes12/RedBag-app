package com.example.kotlin_app.presentation.login

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class UserLoginRequestModel(
    @SerializedName("usernameOrEmail") val email: String,
    @SerializedName("password") val password: String
)

data class UserRegisterRequestModel(
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String = "user0000",
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

data class UserLoginResponseModel(
    @SerializedName("token") val token: String
)
data class UserRegisterResponseModel(
    @SerializedName("id") val token: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String
)