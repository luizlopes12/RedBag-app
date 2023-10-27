package com.example.kotlin_app.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.kotlin_app.R

@Composable
fun LoginPage() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(){
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = R.drawable.login_top_illustration),
                        contentDescription = null
                    )
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