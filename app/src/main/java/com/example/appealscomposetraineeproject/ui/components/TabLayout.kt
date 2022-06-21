package com.example.appealscomposetraineeproject.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.screens.appeal.AppealScreen
import com.example.appealscomposetraineeproject.ui.screens.history.AppealHistoryScreen
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabLayout(pagerState: PagerState) {
    val tabItems = listOf(stringResource(R.string.appeals_title), stringResource(R.string.ah_title))
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            backgroundColor = AppealsComposeTheme.colors.Background,
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(it[pagerState.currentPage]),
                    color = AppealsComposeTheme.colors.Blue,
                    height = 2.dp
                )
            }
        ) {
            tabItems.forEachIndexed { index,title ->

                Tab(selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    enabled = true,
                ) {
                    Text(
                        modifier = Modifier.height(30.dp),
                        fontWeight = FontWeight.Bold,
                        style = AppealsComposeTheme.typography.heading,
                        text = title
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun PagerContent(pagerState: PagerState) {
    CompositionLocalProvider(LocalOverScrollConfiguration provides null) {

        Box(modifier = Modifier.fillMaxSize()){
            HorizontalPager(state = pagerState) {
                    page ->
                when (page) {
                    0-> AppealScreen()
                    1-> AppealHistoryScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreviewCustomTabLayout() {
    MainTheme {
        val pagerState = rememberPagerState(2)
        CustomTabLayout(pagerState)
    }
}