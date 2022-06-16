package com.example.appealscomposetraineeproject.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.screens.appeal.AppealScreen
import com.example.appealscomposetraineeproject.ui.screens.history.AppealHistoryScreen
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabLayout(pagerState: PagerState) {
    val tabItems = listOf(stringResource(R.string.appeals_title), stringResource(R.string.ah_title))
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            backgroundColor = AppealsComposeTheme.colors.Background, //TODO добавить на индикатор синий цвет
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