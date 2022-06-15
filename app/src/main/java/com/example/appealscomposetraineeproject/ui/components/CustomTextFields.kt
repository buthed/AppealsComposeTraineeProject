package com.example.appealscomposetraineeproject.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.ui.screens.appeal.AppealScreen


@Composable
fun CustomTextFields(
    placeholder: String,
    textFieldValue: String,
    onTextFieldChange: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        value = textFieldValue,
        onValueChange = onTextFieldChange,
        label = { Text(placeholder) },
    )
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreviewCustomTextFields() {
//    var themeInput by remember { mutableStateOf("") }
//    CustomTextFields("123",themeInput, { themeInput = it })
//}


