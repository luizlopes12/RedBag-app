package com.example.kotlin_app.presentation.onboarding


import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.kotlin_app.presentation.common.CustomButton
import com.example.kotlin_app.presentation.common.CustomTextButton
import com.example.kotlin_app.presentation.onboarding.components.OnBoardingPage
import com.example.kotlin_app.presentation.shared.emptybottom.EmptyBottom
import com.example.kotlin_app.presentation.shared.emptyheader.EmptyHeader
import com.example.kotlin_app.ui.theme.Orange4
import com.example.kotlin_app.ui.theme.Orange6
import com.example.kotlin_app.ui.theme.Orange7
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .zIndex(1f)
        ) {
            EmptyHeader()
        }
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            onboardingPages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Continuar")
                    1 -> listOf("Voltar", "Continuar")
                    2 -> listOf("Voltar", "Continuar")
                    3 -> listOf("Voltar", "Finalizar")
                    else -> listOf("", "")
                }
            }
        }


        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(
                page = onboardingPages[index],
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    Column {
                    CustomTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Column {
                    CustomButton(
                        text = buttonState.value[1],
                        onClick = {
                            scope.launch {
                                if (pagerState.currentPage == 3) {
                                    navController.navigate("home")
                                } else {
                                    pagerState.animateScrollToPage(
                                        page = pagerState.currentPage + 1
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                onClick = {
                     navController.navigate("home")
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults
                    .buttonColors(
                        contentColor = Orange4,
                        containerColor = Orange7
                    )
            )
            {
                Text(
                    text = "Pular",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
            }
        }
    }
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
    ) {
        EmptyBottom()
    }
}
}