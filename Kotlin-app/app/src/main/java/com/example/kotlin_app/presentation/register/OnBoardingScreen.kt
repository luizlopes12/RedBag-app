package com.example.kotlin_app.presentation.register


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlin_app.presentation.Dimens.MediumPadding2
import com.example.kotlin_app.presentation.common.CustomButton
import com.example.kotlin_app.presentation.common.CustomTextButton
import com.example.kotlin_app.presentation.register.components.OnBoardingPage
import com.example.kotlin_app.presentation.register.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0){
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("", "Continuar")
                    1 -> listOf("Voltar", "Continuar")
                    2 -> listOf("Voltar", "Finalizar")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(
                page = pages[index]
            )
        }
        PageIndicator(
            modifier = Modifier.width(52.dp),
            pageSize = pages.size,
            selectedPage = pagerState.currentPage)

        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MediumPadding2)
            .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically){

                val scope = rememberCoroutineScope()

                if(buttonState.value[0].isNotEmpty()){
                    CustomTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    )
                }

                CustomButton(
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 3){
                                //Navigate to the main screen and save a value in datastore preferences
                            }else{
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}