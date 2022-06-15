package com.example.appealscomposetraineeproject.ui.screens.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.R

@Composable
fun AppealHistoryScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            var search by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(46.dp, 38.dp, 46.dp, 38.dp),
                    shape = RoundedCornerShape(50.dp),
                    value = search,
                    onValueChange = { search = it },
                    label = { Text("Поиск") },
                    leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                )
                Box() {
                    Row() {
                        Text(text = stringResource(id = R.string.date))
                        Text(text = stringResource(id = R.string.number))
                        Text(text = stringResource(id = R.string.theme))
                        Text(text = stringResource(id = R.string.status))
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealHistoryScreen() {
    AppealHistoryScreen()
}