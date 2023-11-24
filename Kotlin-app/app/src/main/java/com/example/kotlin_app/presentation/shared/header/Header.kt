package com.example.kotlin_app.presentation.shared.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.ui.theme.Black
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun Header(navController: NavController) {
    val currentDate = LocalDate.now()
    val currentDay = currentDate.format(DateTimeFormatter.ofPattern("dd 'de' ")).toString()
    val currentMonth = currentDate.format(DateTimeFormatter.ofPattern("MMMM")).toString().capitalize()
    val formattedDate = "$currentDay$currentMonth"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp),
        horizontalAlignment = Alignment.End
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.login_top_illustration),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .width(40.dp)
                .offset(y = (-90).dp, x = (-10).dp)
                .clickable {
                    navController.navigate("configs")
                },
            painter = painterResource(id = R.drawable.config__icon),
            contentDescription = null
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-105).dp),
            horizontalArrangement = Arrangement.Center
        ){
        Text(
            text = formattedDate,
            color = Black,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        )
        }
    }
}