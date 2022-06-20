package com.example.appealscomposetraineeproject

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun TopAppBarCompose(){
    Box(Modifier.height(70.dp)) {
        TopAppBarButton()
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            TopAppBarTitle()
        }

    }
}

@Composable
fun TopAppBarButton(){
    Icon(
        modifier = Modifier
            .fillMaxHeight()
            .size(40.dp),
        tint = AppealsComposeTheme.colors.Blue,
        painter = painterResource(id = R.drawable.icon_back), contentDescription = "Back")
}

@Composable
fun TopAppBarTitle(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.helpdesk),
        textAlign = TextAlign.Center,
        style = AppealsComposeTheme.typography.heading,
        color = AppealsComposeTheme.colors.Blue,
        fontWeight = FontWeight.SemiBold
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewTopAppBarCompose() {
    MainTheme() {
        TopAppBarCompose()
    }
}