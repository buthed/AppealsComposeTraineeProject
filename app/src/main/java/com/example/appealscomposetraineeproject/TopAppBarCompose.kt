package com.example.appealscomposetraineeproject

import android.graphics.Paint
import android.text.Layout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTraineeProjectTheme

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
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewTopAppBarCompose() {
    TopAppBarCompose()
}