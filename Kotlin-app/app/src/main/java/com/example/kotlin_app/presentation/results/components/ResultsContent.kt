package com.example.kotlin_app.presentation.results.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.ui.theme.Gray
import com.example.kotlin_app.ui.theme.Orange1
import com.example.kotlin_app.ui.theme.Orange4
import com.example.kotlin_app.ui.theme.Red
import com.example.kotlin_app.ui.theme.White
import com.example.kotlin_app.ui.theme.WhiteGray
import com.example.kotlin_app.ui.theme.WhiteGray2
import com.example.kotlin_app.ui.theme.WhiteGray4
import com.example.kotlin_app.ui.theme.WhiteGray5
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ResultsContent(navController: NavController) {
    val currentDate = LocalDate.now()
    val currentDay = currentDate.format(DateTimeFormatter.ofPattern("dd 'de' ")).toString()
    val currentMonth = currentDate.format(DateTimeFormatter.ofPattern("MMMM 'de' ")).toString().capitalize()
    val currentYear = currentDate.format(DateTimeFormatter.ofPattern("yyyy")).toString()
    val formattedDate = "$currentDay$currentMonth$currentYear"
    val analisisAcertivity = "93"
    val analisisStatus = "Membrana Pupilar Persistente"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .offset(y = (-80).dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Button(
                    modifier = Modifier
                        .padding(0.dp)
                        .offset(y = (-10).dp, x = (-10).dp),
                    onClick = {
                        navController.navigate("imports")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(size = 6.dp),
                ){
                    Image(
                        modifier = Modifier
                            .width(10.dp),
                        painter = painterResource(id = R.drawable.result__back_arrow),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(10.dp, 0.dp, 0.dp, 0.dp),
                        text = "Voltar",
                        color = Orange1,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .padding(0.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.Transparent,
                            shape = RoundedCornerShape(size = 6.dp)
                        )
                ) {
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
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(.65f)
                        .fillMaxHeight()
                        .background(
                            color = White,
                            shape = RoundedCornerShape(size = 6.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = WhiteGray,
                            shape = RoundedCornerShape(size = 6.dp)
                        ),
                    verticalArrangement = Arrangement.Center,
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 15.dp, 0.dp, 0.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Pré-diagnóstico",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 16.sp,
                                color = WhiteGray4,
                                fontWeight = FontWeight.SemiBold,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 15.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            textAlign = TextAlign.Center,
                            text = analisisStatus,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 26.sp,
                                color = Red,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(.95f)
                        .fillMaxHeight()
                        .background(
                            color = White,
                            shape = RoundedCornerShape(size = 6.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = WhiteGray,
                            shape = RoundedCornerShape(size = 6.dp)
                        ),
                    verticalArrangement = Arrangement.Center,
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 15.dp, 0.dp, 0.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Assertividade",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 16.sp,
                                color = WhiteGray4,
                                fontWeight = FontWeight.SemiBold,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 15.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            textAlign = TextAlign.Center,
                            text = analisisAcertivity,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 34.sp,
                                color = Red,
                                fontWeight = FontWeight.ExtraBold,
                            )
                        )
                        Text(
                            modifier = Modifier.offset(y = (5).dp),
                            textAlign = TextAlign.Center,
                            text = "%",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 20.sp,
                                color = Red,
                                fontWeight = FontWeight.ExtraBold,
                            )
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth(.75f),
                    textAlign = TextAlign.Center,
                    text = "Pré-diagnóstico realizado no dia $formattedDate",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                        color = WhiteGray5,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Button(
                    onClick = {
                              navController.navigate("analyze")
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
                        text = "Nova análise",
                        color = White,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    )
                }
            }
        }
    }
}