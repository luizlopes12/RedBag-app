package com.example.kotlin_app.presentation.shared.emptybottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlin_app.R

@Composable
fun EmptyBottom() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (30).dp),
            painter = painterResource(id = R.drawable.login_bottom_illustration),
            contentDescription = null
        )
    }
}