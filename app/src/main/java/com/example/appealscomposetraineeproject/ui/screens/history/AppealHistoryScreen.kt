package com.example.appealscomposetraineeproject.ui.screens.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.SortAttributes
import com.example.appealscomposetraineeproject.ui.screens.history.components.AppealsTable
import com.example.appealscomposetraineeproject.ui.screens.history.components.SearchField
import com.example.appealscomposetraineeproject.ui.theme.MainTheme
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel

interface AppealHistoryScreenCallback{
    fun onSearch(query: String)
    fun onSort(column: SortAttributes)
    fun onGetData()
}

@Composable
fun AppealHistoryScreen(
    appealData: State<List<Appeal>>,
    model: MainViewModel,
    callback: AppealHistoryScreenCallback
) {

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
                            callback.onSearch(onQueryChanged)
                        }
                    },
                    iconModifier = Modifier.clickable{
                        search = ""
                        callback.onGetData()
                    })
                Spacer(modifier = Modifier.height(35.dp))
                AppealsTable(appealData.value, model)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreviewAppealHistoryScreen() {
//    val viewModel: MainViewModel = MainViewModel()
//
//    val appealsData: State<List<Appeal>> = viewModel.appeals.observeAsState(listOf())
//    MainTheme {
//        AppealHistoryScreen(appealsData)
//    }
//}