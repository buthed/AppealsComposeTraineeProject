package com.example.appealscomposetraineeproject

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun TopAppBarCompose(){
    Box(Modifier.height(50.dp)) {
        TopAppBarButton()
        TopAppBarTitle()
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
fun TopAppBarTitle() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = stringResource(id = R.string.helpdesk),
        textAlign = TextAlign.Center,
        style = AppealsComposeTheme.typography.heading,
        color = AppealsComposeTheme.colors.Blue
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewTopAppBarCompose() {
    MainTheme() {
        TopAppBarCompose()
    }
}