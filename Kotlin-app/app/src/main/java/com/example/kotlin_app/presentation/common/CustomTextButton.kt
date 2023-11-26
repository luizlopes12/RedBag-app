package com.example.kotlin_app.presentation.common


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_app.R
import com.example.kotlin_app.ui.theme.Gray
import com.example.kotlin_app.ui.theme.Orange4
import com.example.kotlin_app.ui.theme.WhiteGray
import com.example.kotlin_app.ui.theme.WhiteGray2

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = Orange4,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ){
        Text(text = text, style = androidx.compose.ui.text.TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
        ))
    }
}


@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(55.dp)
            .width(55.dp)
            .background(
                color = WhiteGray2,
                shape = RoundedCornerShape(size = 5.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = WhiteGray2,
            contentColor = Color.White
        )
    ){
            Image(
                painter = painterResource(id = R.drawable.register_prev_icon),
                contentDescription = null
            )
    }
}