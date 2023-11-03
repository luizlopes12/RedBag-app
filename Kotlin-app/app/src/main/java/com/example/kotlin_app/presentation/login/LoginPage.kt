package com.example.kotlin_app.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.kotlin_app.R
import com.example.kotlin_app.ui.theme.WhiteGray
import com.example.kotlin_app.ui.theme.Black


@Composable
fun LoginPage() {
    var email by remember { mutableStateOf("") }
    var emailPlaceholder by remember { mutableStateOf("Email") }
    var password by remember { mutableStateOf("") }
    var passwordPlaceholder by remember { mutableStateOf("Senha") }

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
                        .padding(horizontal = 16.dp),
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                                 BasicTextField(
                                     value = email,
                                     onValueChange = { email = it; emailPlaceholder = ""
                                     },
                                     modifier = Modifier
                                         .fillMaxWidth()
                                         .background(WhiteGray)
                                         .padding(
                                             top = 10.dp,
                                             bottom = 10.dp,
                                             start = 5.dp,
                                             end = 5.dp
                                         ),
                                 ) {
                                     Text(
                                         text = email,
                                         style = MaterialTheme.typography.bodyLarge,
                                         color = Black,
                                     )
                                     Text(
                                         text = emailPlaceholder,
                                         style = MaterialTheme.typography.bodyLarge,
                                         color = Color.Gray
                                     )
                                 }
                             }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            BasicTextField(
                                value = password,
                                onValueChange = { password = it; passwordPlaceholder = ""
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(WhiteGray)
                                    .padding(
                                        top = 10.dp,
                                        bottom = 10.dp,
                                        start = 5.dp,
                                        end = 5.dp
                                    ),
                            ) {
                                Text(
                                    text = password,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Black,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                                Text(
                                    text = passwordPlaceholder,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                            }
                        }
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
                            .offset(y = (20).dp),
                        onClick = { /*TODO*/ },
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

@Preview
@Composable
fun LoginPagePreview() {
    LoginPage()
}