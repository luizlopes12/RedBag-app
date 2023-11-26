package com.example.kotlin_app.presentation.imports.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.ui.theme.Black
import com.example.kotlin_app.ui.theme.WhiteGray3
import com.example.kotlin_app.ui.theme.WhiteGray4
import com.example.kotlin_app.ui.theme.WhiteGray5
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ListCard(navController: NavController) {
    val currentDate = LocalDate.now()
    val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")).toString()
    val analisisAcertivity = "93"
    val analisisStatus = "MPP"
    val analisisPetName = "Anônimo"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 6.dp)
            )
            .clickable {
                navController.navigate("results")
            }
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                        .background(
                            color = Color.Transparent,
                            shape = RoundedCornerShape(size = 6.dp)
                        ),
                    painter = painterResource(id = R.drawable.analisis__result_image),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    textAlign = TextAlign.Center,
                    text = formattedDate,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = WhiteGray4,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = analisisPetName,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        color = Black,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    textAlign = TextAlign.Center,
                    text = "Pré-diagnóstico",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = WhiteGray4,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = analisisStatus,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        color = Black,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    textAlign = TextAlign.Center,
                    text = "Assertividade",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = WhiteGray4,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = "${analisisAcertivity}%",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        color = Black,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }
    }
}