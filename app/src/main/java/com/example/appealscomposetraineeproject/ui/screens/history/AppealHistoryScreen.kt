package com.example.appealscomposetraineeproject.ui.screens.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.ui.screens.history.components.AppealsTable
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun AppealHistoryScreen() {
    Scaffold(Modifier.fillMaxSize()) {
        Surface(Modifier.fillMaxWidth()) {
            var search by remember { mutableStateOf("") }

            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(31.dp)
                        .padding(horizontal = 46.dp, vertical = 38.dp),
                    shape = RoundedCornerShape(50.dp),
                    value = search,
                    onValueChange = { search = it },
                    label = { Text(stringResource(R.string.ah_search_hint)) },
                    leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                )
                Spacer(modifier = Modifier.height(50.dp))
                AppealsTable()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealHistoryScreen() {
    MainTheme {
        AppealHistoryScreen()
    }
}