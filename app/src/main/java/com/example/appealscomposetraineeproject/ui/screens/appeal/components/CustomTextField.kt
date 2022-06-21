package com.example.appealscomposetraineeproject.ui.screens.appeal.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun CustomTextFieldTest() {
    var input by remember { mutableStateOf("input") }

    CustomTextField(
        modifier = Modifier.padding(30.dp),
        label = "Test label",
        input = input,
    )
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
    input: String,
    label: String,
) {
    var inputs by remember { mutableStateOf(input) }

    TextField(
        modifier = modifier,
        value = inputs,
        onValueChange = { inputs = it},
        label = { Text(label) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = AppealsComposeTheme.colors.Background,
            focusedLabelColor = AppealsComposeTheme.colors.GraySpaces,
            focusedIndicatorColor = AppealsComposeTheme.colors.Blue,
            unfocusedIndicatorColor = AppealsComposeTheme.colors.GraySpaces
        ),
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppealDropDownMenu(modifier: Modifier = Modifier
    .fillMaxWidth()
    .height(50.dp),
   label: String
) {
    val options  = listOf(
        stringResource(R.string.at_testimony),
        stringResource(R.string.at_debt),
        stringResource(R.string.at_accrual_ODN))

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(label) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = AppealsComposeTheme.colors.Background,
                focusedLabelColor = AppealsComposeTheme.colors.GraySpaces,
                focusedIndicatorColor = AppealsComposeTheme.colors.Blue,
                unfocusedIndicatorColor = AppealsComposeTheme.colors.GraySpaces
            ),
            textStyle = TextStyle(fontSize = 16.sp )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewCustomTextFieldTest() {
    MainTheme {
        CustomTextFieldTest()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealDropDownMenu() {
    MainTheme {
        AppealDropDownMenu(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.appeals_theme))
    }
}