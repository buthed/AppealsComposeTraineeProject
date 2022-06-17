package com.example.appealscomposetraineeproject.ui.screens.history.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme

import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun SearchField() {
    var search by remember { mutableStateOf("") }
    var focusState by remember { mutableStateOf(false) }
    Box(){
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 46.dp)
                .height(31.dp)
                .background(AppealsComposeTheme.colors.Background)
                .onFocusChanged { focus ->
                    focusState = focus.isFocused
                },
            textStyle = AppealsComposeTheme.typography.tableText,
            shape = RoundedCornerShape(50.dp),
            value = search,
            onValueChange = { search = it },
            label = { Text(
                text = if (focusState) "" else stringResource(R.string.ah_search_hint))
            },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
        )
    }

}

@Composable
fun RoundedCornerShapeDemo(){
    ExampleBox(shape = RoundedCornerShape(10.dp))
}

@Composable
fun ExampleBox(shape: Shape){
    Column(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
        Box(
            modifier = Modifier.size(100.dp,10.dp).clip(shape).background(Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewSearchField() {
    MainTheme {
        SearchField()
    }
}