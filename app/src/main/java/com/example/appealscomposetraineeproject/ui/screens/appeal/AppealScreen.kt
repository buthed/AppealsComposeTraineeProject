package com.example.appealscomposetraineeproject.ui.screens.appeal

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun AppealScreen(
) {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)) {

        Surface(
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            var themeInput by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(50.dp),
                    value = themeInput,
                    onValueChange = { themeInput = it },
                    label = { Text(stringResource(R.string.appeals_theme)) },
                    trailingIcon = { Icon(Icons.Filled.ArrowDropDown, contentDescription = "List") },
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(50.dp),
                    value = themeInput,
                    onValueChange = { themeInput = it },
                    label = { Text(stringResource(R.string.appeals_account_number)) },
                )
                //TODO Доделать кастомный переиспользуемый инпут
                Box() {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        text = stringResource(R.string.appeals_attach_files),
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.appeals_sent_button))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealScreen() {
    MainTheme {
        AppealScreen()
    }
}