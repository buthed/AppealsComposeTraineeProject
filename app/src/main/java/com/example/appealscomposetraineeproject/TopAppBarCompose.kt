package com.example.appealscomposetraineeproject

import android.content.res.Resources
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text

import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun TopAppBarCompose(){
    TopAppBar(
        title = { TopAppBarTitle() },
        navigationIcon = {
            Icon(painter = painterResource(id = R.drawable.icon_left), contentDescription = "Back")
        }
    )
    //TODO переделать на row?
}

@Composable
fun TopAppBarTitle() {
    Box() {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.helpdesk),
            textAlign = TextAlign.Center,
            style = AppealsComposeTheme.typography.body,
            color = AppealsComposeTheme.colors.RedStatus
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewTopAppBarCompose() {
    MainTheme() {
        TopAppBarCompose()
    }
}