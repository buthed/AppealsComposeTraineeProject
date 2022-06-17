package com.example.appealscomposetraineeproject.ui.screens.appeal.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    modifier: Modifier = Modifier.fillMaxWidth().height(50.dp),
    input: String,
    label: String
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
        )
    )
}



@Preview(showBackground = true)
@Composable
fun DefaultPreviewCustomTextFieldTest() {
    MainTheme {
        CustomTextFieldTest()
    }
}