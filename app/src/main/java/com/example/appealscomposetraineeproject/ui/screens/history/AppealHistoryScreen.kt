package com.example.appealscomposetraineeproject.ui.screens.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.ui.screens.history.components.AppealsTable
import com.example.appealscomposetraineeproject.ui.screens.history.components.SearchField
import com.example.appealscomposetraineeproject.ui.theme.MainTheme
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel

@Composable
fun AppealHistoryScreen(model: MainViewModel) {

    val appealsData: State<List<Appeal>> = model.appeals.observeAsState(listOf())

    model.getAppeals()

    Scaffold(Modifier.fillMaxSize()) { padding ->
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
                    input = search,
                    onValueChange = { onQueryChanged ->
                        search = onQueryChanged
                        if (onQueryChanged.isNotEmpty()) {
                            model.search(onQueryChanged)
                        }
                    },
                    iconModifier = Modifier.clickable{
                        search = ""
                        model.getAppeals()
                    })
                Spacer(modifier = Modifier.height(35.dp))
                AppealsTable(appealsData.value, model)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealHistoryScreen() {
    MainTheme {
        AppealHistoryScreen(viewModel())
    }
}