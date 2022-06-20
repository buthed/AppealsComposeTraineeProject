package com.example.appealscomposetraineeproject.ui.screens.history.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme

import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    input: String
) {
    var search by remember { mutableStateOf(input) }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(31.dp),
        border = BorderStroke(2.dp, AppealsComposeTheme.colors.Gray),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(16.dp).weight(1f).padding(start = 14.dp)) {
                Icon(
                    painterResource(id = R.drawable.icon_search),
                    contentDescription = "Search",
                    tint = AppealsComposeTheme.colors.GrayLabel)
            }
            BasicTextField(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(6f)
                    .padding(vertical = 7.dp),
                value = search,
                onValueChange = { search = it },
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                ),
                decorationBox = {innerTextField ->
                        if (search.isEmpty()) {
                            Row() {
                                Text(
                                    modifier = Modifier.fillMaxSize(),
                                    text = stringResource(id = R.string.ah_search_hint),
                                    color = if (isSystemInDarkTheme()) Color(0xFF969EBD) else Color.Gray,
                                    fontSize = 12.sp,
                                    lineHeight = 14.sp,
                                )
                            }

                        } else {
                            Box(
                                modifier = Modifier.size(14.dp).weight(1f).padding(end = 14.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(painterResource(id = R.drawable.icon_clear), contentDescription = "Search")
                            }
                        }
                    innerTextField()
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewSearchField() {
    var search by remember { mutableStateOf("") }
    MainTheme {
        SearchField( modifier = Modifier
            .fillMaxWidth()
            .height(31.dp)
            .padding(horizontal = 46.dp),
            input = search,)
    }
}