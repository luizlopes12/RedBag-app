package com.example.kotlin_app.presentation.register


import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.kotlin_app.presentation.common.CustomButton
import com.example.kotlin_app.presentation.common.CustomTextButton
import com.example.kotlin_app.presentation.login.UserLoginRequestModel
import com.example.kotlin_app.presentation.login.UserRegisterRequestModel
import com.example.kotlin_app.presentation.login.UserRegisterResponseModel
import com.example.kotlin_app.presentation.register.components.RegisterPage
import com.example.kotlin_app.presentation.shared.emptybottom.EmptyBottom
import com.example.kotlin_app.presentation.shared.emptyheader.EmptyHeader
import com.example.kotlin_app.utils.ApiService
import kotlinx.coroutines.launch
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val randomNumber = (0..100).random()
    val retrofit = RetrofitHelper.getRetrofitInstance("https://red-bag-api-distroless.onrender.com/")
    val apiService = retrofit.create(ApiService::class.java)
    val scope = rememberCoroutineScope()
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val username = "user-$randomNumber"


    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .zIndex(1f)
        ) {
            EmptyHeader()
        }
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Continuar")
                    1 -> listOf("Voltar", "Continuar")
                    2 -> listOf("Voltar", "Finalizar")
                    else -> listOf("", "")
                }
            }
        }


        HorizontalPager(state = pagerState) { index ->
            RegisterPage(
                name = name,
                email = email,
                password = password,
                page = pages[index],
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {


                if (buttonState.value[0].isNotEmpty()) {
                    Column {
                    CustomTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Column {
                    CustomButton(
                        text = buttonState.value[1],
                        onClick = {
                            scope.launch {
                                if (pagerState.currentPage == 2) {
                                    val userRegisterRequest = UserRegisterRequestModel(
                                        name = name.value,
                                        email = email.value,
                                        username = username,
                                        password = password.value
                                    )

                                    scope.launch {
                                        try {
                                            val registerResponse = apiService.signup(userRegisterRequest)
                                            if (registerResponse.isSuccessful) {
                                                navController.navigate("onboarding")
                                            } else {
                                                print("Login deu merda no RegisterScreen")
                                            }
                                        } catch (e: IOException) {
                                            // Handle network error
                                            print("Network error")
                                        }
                                    }
                                } else {
                                    pagerState.animateScrollToPage(
                                        page = pagerState.currentPage + 1
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
    ) {
        EmptyBottom()
    }
}
}