package com.example.kotlin_app.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.presentation.shared.header.Header
import com.example.kotlin_app.presentation.shared.navbar.Navbar
import com.example.kotlin_app.ui.theme.Black
import com.example.kotlin_app.ui.theme.Gray
import com.example.kotlin_app.ui.theme.Orange1
import com.example.kotlin_app.ui.theme.Orange4
import com.example.kotlin_app.ui.theme.Orange5
import com.example.kotlin_app.ui.theme.Red
import com.example.kotlin_app.ui.theme.White

@Composable
fun HomePage(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .height(50.dp)
    ) {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Header(navController = navController)
            Column(
                modifier = Modifier
                    .offset(y = (-60).dp)
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .height(150.dp)
                            .background(
                                White,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                modifier = Modifier
                                    .offset(y = (-12).dp, x = (-4).dp),
                                text = "25",
                                color = Gray,
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                )
                            )
                            Text(
                                modifier = Modifier
                                    .offset(y = (-8).dp),
                                text = "/",
                                color = Gray,
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                )
                            )
                            Text(
                                modifier = Modifier
                                    .offset(x = (4).dp),
                                text = "100",
                                color = Gray,
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                )
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = "25%",
                                color = Black,
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )
                        }
                        Spacer(modifier = Modifier
                            .height(2.dp)
                            .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier
                            .height(4.dp)
                            .fillMaxWidth(.75f)
                            .background(
                                Orange4,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = "Casos positivos",
                                color = Black,
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                Orange4,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                            )
                            .clickable {
                                navController.navigate("analyze")
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .width(80.dp),
                            painter = painterResource(id = R.drawable.new__analisis__icon),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier
                                .padding(0.dp, 10.dp, 0.dp, 0.dp),
                            text = "Nova Análise",
                            color = White,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Histórico geral",
                            color = Black,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults
                                .buttonColors(
                                    contentColor = White,
                                    containerColor = Orange4
                                )
                        )
                        {
                            Text(
                                text = "Mensal",
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = White,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        modifier = Modifier
                            .fillMaxWidth(),
                        painter = painterResource(id = R.drawable.home__graph),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ){
            Navbar(navbarSelected = 0, navController = navController)
        }
    }
}