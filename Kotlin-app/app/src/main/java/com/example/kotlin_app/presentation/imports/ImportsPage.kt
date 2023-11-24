package com.example.kotlin_app.presentation.imports

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.presentation.shared.header.Header
import com.example.kotlin_app.presentation.shared.navbar.Navbar
import com.example.kotlin_app.ui.theme.Black
import com.example.kotlin_app.ui.theme.Gray
import com.example.kotlin_app.ui.theme.Orange1
import com.example.kotlin_app.ui.theme.Orange3
import com.example.kotlin_app.ui.theme.White
import com.example.kotlin_app.ui.theme.WhiteGray
import com.example.kotlin_app.ui.theme.WhiteGray2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportsPage(navController: NavController) {
    var search = remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize(),
        ) {
            Header(navController = navController)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-50).dp)
                    .padding(10.dp)
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Orange3,
                        textColor = Black,
                        containerColor = White,
                        focusedIndicatorColor = Orange3,
                        unfocusedIndicatorColor = WhiteGray2,
                        disabledIndicatorColor = White,
                        errorIndicatorColor = Color.Red,
                    ),
                    value = search.value,
                    onValueChange = {
                        search.value = it
                    },
                    label = { Text("Buscar", color = Orange1) },
                )
            }

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ){
            Navbar(navbarSelected = 2, navController = navController)
        }
    }
}