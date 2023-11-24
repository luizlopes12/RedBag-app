package com.example.kotlin_app.presentation.analisis

import android.content.Context
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.presentation.shared.header.Header
import com.example.kotlin_app.presentation.shared.navbar.Navbar
import com.example.kotlin_app.ui.theme.Gray
import com.example.kotlin_app.ui.theme.Orange4
import com.example.kotlin_app.ui.theme.Red
import com.example.kotlin_app.ui.theme.White
import com.example.kotlin_app.ui.theme.WhiteGray
import com.example.kotlin_app.ui.theme.WhiteGray3
import com.example.kotlin_app.utils.FileViewModel
import java.io.File


@RequiresApi(Build.VERSION_CODES.S)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun AnalisisPage(navController: NavController, context: Context) {
    val viewModel = viewModel<FileViewModel>()

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
            // Handle the selected file URI
            uri?.let { fileUri ->
                val file = File(fileUri.path ?: "")
                viewModel.uploadImage(file) { success ->
                    if (success) {
                        // Handle successful upload
                    } else {
                        // Handle failed upload
                    }
                }
            }
        }

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
                    .padding(10.dp)
                    .offset(y = (-60).dp),
            ){
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .border(1.dp, WhiteGray3, RoundedCornerShape(5.dp))
                            .background(
                                color = White,
                                shape = RoundedCornerShape(5.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.width(10.dp))
                                Column() {
                                    Image(
                                        modifier = Modifier
                                            .width(20.dp)
                                            .height(20.dp),
                                        painter = painterResource(id = R.drawable.analisis__name_icon_png),
                                        contentDescription = null
                                    )
                                }
                                Spacer(modifier = Modifier.width(5.dp))
                                Column() {
                                    Text(text = "Aleatório", color = Gray)
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row {
                                Image(
                                    modifier = Modifier
                                        .width(16.dp)
                                        .height(16.dp),
                                    painter = painterResource(id = R.drawable.analisis__name_down_arrow_png),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(214.dp)
                    ){
                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            painter = painterResource(id = R.drawable.analisis__photo_placeholder),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(
                                color = Orange4,
                                shape = RoundedCornerShape(5.dp)
                            ),
                        colors = ButtonDefaults
                            .buttonColors(
                                contentColor = White,
                                containerColor = Orange4
                            ),
                        onClick = { launcher.launch("image/*") }
                    ) {
                        Image(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            painter = painterResource(id = R.drawable.upload__btn__icon),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Upload",
                            color = White,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 20.sp,
                                fontWeight = SemiBold,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 16.sp,
                            fontWeight = SemiBold,
                        ),
                        color = Gray,
                        text = "Faça uma nova análise do seu pet, aproxime o olho dele da câmera para uma melhor experiência.",
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ){
            Navbar(navbarSelected = 1, navController = navController)
        }
    }
}