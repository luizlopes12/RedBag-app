package com.example.kotlin_app.presentation.register.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_app.presentation.Dimens.MediumPadding1
import com.example.kotlin_app.presentation.register.Page
import com.example.kotlin_app.presentation.register.pages
import com.example.kotlin_app.ui.theme.Black
import com.example.kotlin_app.ui.theme.Orange1
import com.example.kotlin_app.ui.theme.Orange3
import com.example.kotlin_app.ui.theme.WhiteGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(
    modifier: Modifier = Modifier,
    page: Page,
    name: MutableState<String>,
    email: MutableState<String>,
    password: MutableState<String>
){


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){

        Text(
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = Black
        )
        }
        Spacer(modifier = Modifier.height(MediumPadding1))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.4f),
                painter = painterResource(
                    id = page.image
                ), contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        PageIndicator(
            modifier = Modifier.width(50.dp),
            pageSize = pages.size,
            selectedPage = pages.indexOf(page)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = page.description,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                ),
                color = Black
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
            if (page.id == 0) {
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Orange3,
                        textColor = Black,
                        containerColor = WhiteGray,
                        focusedIndicatorColor = Orange3,
                        unfocusedIndicatorColor = Orange3,
                        disabledIndicatorColor = WhiteGray,
                        errorIndicatorColor = Color.Red,
                    ),
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    label = { Text("Nome", color = Orange1)  },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if (page.id == 1) {
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Orange3,
                        textColor = Black,
                        containerColor = WhiteGray,
                        focusedIndicatorColor = Orange3,
                        unfocusedIndicatorColor = Orange3,
                        disabledIndicatorColor = WhiteGray,
                        errorIndicatorColor = Color.Red,
                    ),
                    value = email.value,
                    onValueChange = {
                        email.value = it
                    },
                    label = { Text("Email", color = Orange1)  },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if (page.id == 2) {
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Orange3,
                        textColor = Black,
                        containerColor = WhiteGray,
                        focusedIndicatorColor = Orange3,
                        unfocusedIndicatorColor = Orange3,
                        disabledIndicatorColor = WhiteGray,
                        errorIndicatorColor = Color.Red,
                    ),
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    label = { Text("Senha", color = Orange1)  },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
    }
}
