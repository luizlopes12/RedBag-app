package com.example.kotlin_app.presentation.common


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
            .height(50.dp),
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = Orange4,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ){
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}


@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit
){
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .height(50.dp),
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Gray
        )
    }
}