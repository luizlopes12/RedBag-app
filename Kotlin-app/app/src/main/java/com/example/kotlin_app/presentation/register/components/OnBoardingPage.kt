package com.example.kotlin_app.presentation.register.components


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_app.R
import com.example.kotlin_app.presentation.Dimens.MediumPadding1
import com.example.kotlin_app.presentation.Dimens.MediumPadding2
import com.example.kotlin_app.presentation.register.Page
import com.example.kotlin_app.ui.theme.Black
import com.example.kotlin_app.ui.theme.Gray
import com.example.kotlin_app.ui.theme.WhiteGray

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
){
    Column(
        modifier = Modifier
            .fillMaxWidth(.9f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){

        Text(
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = Black
        )
        }
        Spacer(modifier = Modifier.height(MediumPadding1))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.45f),
                painter = painterResource(
                    id = page.image
                ), contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(MediumPadding1))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = page.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Gray
            )
        }
    }
}
