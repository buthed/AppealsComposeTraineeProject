package com.example.appealscomposetraineeproject.ui.screens.appeal

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.screens.appeal.components.AppealDropDownMenu
import com.example.appealscomposetraineeproject.ui.screens.appeal.components.CustomTextField
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun AppealScreen() {
    Scaffold(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 40.dp)) {

        Surface(Modifier.fillMaxWidth()) {
            var themeInput by remember { mutableStateOf("") }
            var accountNumberInput by remember { mutableStateOf("") }
            var fullNameInput by remember { mutableStateOf("") }
            var addressInput by remember { mutableStateOf("") }
            var phoneNumberInput by remember { mutableStateOf("") }
            var emailInput by remember { mutableStateOf("") }
            var textInput by remember { mutableStateOf("") }

            Column{
                AppealDropDownMenu(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.appeals_theme))
                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    input = accountNumberInput,
                    label = stringResource(R.string.appeals_account_number))
                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    input = fullNameInput,
                    label = stringResource(R.string.appeals_initials))
                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    input = addressInput,
                    label = stringResource(R.string.appeals_address))
                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    input = phoneNumberInput,
                    label = stringResource(R.string.appeals_phone))
                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    input = emailInput,
                    label = stringResource(R.string.appeals_email))
                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    input = textInput,
                    label = stringResource(R.string.appeals_text_of_appeal))

                Box() {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp),
                        color = AppealsComposeTheme.colors.Blue,
                        text = stringResource(R.string.appeals_attach_files),
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = AppealsComposeTheme.colors.Blue,
                        contentColor = Color.White,
                        disabledContentColor = AppealsComposeTheme.colors.GrayLabel,

                    )
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