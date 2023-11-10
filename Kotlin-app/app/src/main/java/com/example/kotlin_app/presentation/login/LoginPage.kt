    package com.example.kotlin_app.presentation.login
    
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.material3.TextField
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.offset
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextButton
    import androidx.compose.material3.TextFieldDefaults
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.rememberCoroutineScope
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.input.PasswordVisualTransformation
    import androidx.compose.ui.text.style.TextDecoration
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.zIndex
    import android.util.Log
    import androidx.navigation.NavController
    import com.example.kotlin_app.R
    import com.example.kotlin_app.ui.theme.WhiteGray
    import com.example.kotlin_app.ui.theme.Black
    import com.example.kotlin_app.ui.theme.Gray
    import com.example.kotlin_app.ui.theme.Orange1
    import com.example.kotlin_app.ui.theme.Orange3
    import com.example.kotlin_app.ui.theme.Orange4
    import com.example.kotlin_app.ui.theme.White
    import com.google.gson.Gson
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.GlobalScope
    import kotlinx.coroutines.launch
    import okhttp3.MediaType
    import okhttp3.RequestBody
    import retrofit2.Response
    import retrofit2.http.Body
    import retrofit2.http.POST
    import java.io.IOException
    
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginPage(navController: NavController){
        var email = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        var warningText = remember { mutableStateOf("") }
        val coroutineScope = rememberCoroutineScope()
        val gson = Gson()
    
        MaterialTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(){
                        Image(
                            modifier = Modifier.fillMaxWidth(),
                            painter = painterResource(id = R.drawable.login_top_illustration),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.9f)
                            .padding(horizontal = 2.dp),
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp),
                                horizontalArrangement = Arrangement.Center,
                            ){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.ic_logo),
                                    contentDescription = null
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .background(WhiteGray)
                                        .fillMaxWidth(),
                                    colors = TextFieldDefaults.textFieldColors(
                                        cursorColor = Orange3,
                                        textColor = Black,
                                        containerColor = WhiteGray,
                                        focusedIndicatorColor = Orange3,
                                        unfocusedIndicatorColor = Gray,
                                        disabledIndicatorColor = WhiteGray,
                                        errorIndicatorColor = Color.Red,
                                    ),
                                    value = email.value,
                                    onValueChange = {
                                        email.value = it
                                    },
                                    label = { Text("Email", color = Orange1) },
                                    )
                                 }
    
                            Spacer(modifier = Modifier.height(10.dp))
    
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .background(WhiteGray)
                                        .fillMaxWidth(),
                                    colors = TextFieldDefaults.textFieldColors(
                                        cursorColor = Orange3,
                                        textColor = Black,
                                        containerColor = WhiteGray,
                                        focusedIndicatorColor = Orange3,
                                        unfocusedIndicatorColor = Gray,
                                        disabledIndicatorColor = WhiteGray,
                                        errorIndicatorColor = Color.Red,
                                    ),
                                    value = password.value,
                                    onValueChange = {
                                        password.value = it
                                    },
                                    label = { Text("Senha", color = Orange1)  },
                                    visualTransformation = PasswordVisualTransformation(),
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Button(
                                    onClick = {
                                        val userLoginRequest = UserLoginRequestModel(email = email.value, password = password.value)
                                        navController.navigate("home")
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .background(Orange4, RoundedCornerShape(5.dp)),
                                        colors = ButtonDefaults
                                            .buttonColors(
                                            contentColor = White,
                                            containerColor = Orange4
                                        )
                                    ){
                                    Text(
                                        text = "Entrar",
                                        color = White,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
                            }
                            Spacer(modifier = Modifier
                                .height(60.dp)
                            )
                        }
                    }
                    Box() {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .zIndex(1f),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                        TextButton(
                            modifier = Modifier
                                .offset(y = (10).dp),
                            onClick = {
                                navController.navigate("signup")
                                      },
                        ) {
                                Text(
                                    text = "Não possui uma conta?",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyLarge,
                                    textDecoration = TextDecoration.Underline
                                )
                            }
                        }
    
    
                        Image(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                painter = painterResource(id = R.drawable.login_bottom_illustration),
                                contentDescription = null
                            )
                    }
                    }
                }
        }
    }
    
    
    
    /*
    @Preview
    @Composable
    fun LoginPagePreview() {
        LoginPage()
    }
    */