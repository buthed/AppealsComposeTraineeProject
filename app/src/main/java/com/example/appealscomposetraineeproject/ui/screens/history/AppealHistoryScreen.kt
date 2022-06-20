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
import com.example.appealscomposetraineeproject.model.entities.getAppeals
import com.example.appealscomposetraineeproject.ui.screens.history.components.AppealsTable
import com.example.appealscomposetraineeproject.ui.screens.history.components.SearchField
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun AppealHistoryScreen() {
    val data = getAppeals()

    Scaffold(Modifier.fillMaxSize()) {
        Surface(Modifier.fillMaxWidth()) {
            var search by remember { mutableStateOf("") }

            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(31.dp))
                SearchField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(31.dp)
                        .padding(horizontal = 46.dp),
                    input = search,)
                Spacer(modifier = Modifier.height(35.dp))
                AppealsTable(data)
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