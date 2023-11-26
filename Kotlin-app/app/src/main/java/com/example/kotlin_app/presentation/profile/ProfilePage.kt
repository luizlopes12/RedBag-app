package com.example.kotlin_app.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.presentation.login.UserLoginRequestModel
import com.example.kotlin_app.presentation.shared.header.Header
import com.example.kotlin_app.presentation.shared.navbar.Navbar
import com.example.kotlin_app.ui.theme.Black
import com.example.kotlin_app.ui.theme.Gray
import com.example.kotlin_app.ui.theme.Orange1
import com.example.kotlin_app.ui.theme.Orange3
import com.example.kotlin_app.ui.theme.Orange4
import com.example.kotlin_app.ui.theme.Orange6
import com.example.kotlin_app.ui.theme.White
import com.example.kotlin_app.ui.theme.WhiteGray
import com.example.kotlin_app.ui.theme.WhiteGray2
import kotlinx.coroutines.launch
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navController: NavController) {
    val name = remember { mutableStateOf("Teste Nome") }
    val email = remember { mutableStateOf("Teste Email") }
    val password = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Header(navController = navController)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .offset(y = (-60).dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .width(50.dp)
                                .offset(x = (-25).dp),
                            painter = painterResource(id = R.drawable.delete__user_icon),
                            contentDescription = null
                        )
                        Image(
                            modifier = Modifier
                                .width(200.dp)
                                .offset(x = (-25).dp),
                            painter = painterResource(id = R.drawable.user__profile_icon),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
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
                                unfocusedIndicatorColor = Orange4,
                                disabledIndicatorColor = WhiteGray,
                                errorIndicatorColor = Color.Red,
                            ),
                            value = name.value,
                            onValueChange = {
                                name.value = it
                            },
                            label = { Text("Nome", color = Orange1) },
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
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
                                unfocusedIndicatorColor = Orange4,
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
                            .background(Color.Red),
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
                                unfocusedIndicatorColor = Orange4,
                                disabledIndicatorColor = WhiteGray,
                                errorIndicatorColor = Color.Red,
                            ),
                            value = password.value,
                            onValueChange = {
                                password.value = it
                            },
                            label = { Text("Senha", color = Orange1) },
                            visualTransformation = PasswordVisualTransformation(),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Button(
                            onClick = {
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .background(Orange4, RoundedCornerShape(5.dp)),
                            colors = ButtonDefaults
                                .buttonColors(
                                    contentColor = White,
                                    containerColor = Orange4
                                )
                        ){
                            Text(
                                text = "Salvar",
                                color = White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Navbar(navbarSelected = 4, navController = navController)
        }
    }
}