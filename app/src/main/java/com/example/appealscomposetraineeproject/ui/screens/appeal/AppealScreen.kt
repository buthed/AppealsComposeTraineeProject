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

@Composable
fun AppealScreen(
    onTextFieldChange: String
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
                    label = { Text(stringResource(id = R.string.theme)) },
                    trailingIcon = { Icon(Icons.Filled.ArrowDropDown, contentDescription = "List") },
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(50.dp),
                    value = themeInput,
                    onValueChange = { themeInput = it },
                    label = { Text(stringResource(id = R.string.account_number)) },
                )
                //TODO Доделать кастомный переиспользуемый инпут
                Box() {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        text = stringResource(id = R.string.attach_files),
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.sent))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealScreen() {
    AppealScreen("123")
}