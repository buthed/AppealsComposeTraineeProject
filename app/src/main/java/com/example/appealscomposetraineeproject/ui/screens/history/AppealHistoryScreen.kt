package com.example.appealscomposetraineeproject.ui.screens.history

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appealscomposetraineeproject.model.AppStateAppeals
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.getAppeals
import com.example.appealscomposetraineeproject.model.repository.Repository
import com.example.appealscomposetraineeproject.model.repository.RepositoryImpl
import com.example.appealscomposetraineeproject.ui.screens.history.components.AppealsTable
import com.example.appealscomposetraineeproject.ui.screens.history.components.SearchField
import com.example.appealscomposetraineeproject.ui.theme.MainTheme
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel

@Composable
fun AppealHistoryScreen(model: MainViewModel = viewModel()) {
    var data: List<Appeal> = getAppeals()

//    var data: List<Appeal> = model.getAppeals() //TODO перегружается память

    data = model.sortByDate(data,model.isIncrease)
    //TODO Сортировка работает, осталось отловить клик и сменить тип даты


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