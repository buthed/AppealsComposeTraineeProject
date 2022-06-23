package com.example.appealscomposetraineeproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.SortAttributes
import com.example.appealscomposetraineeproject.model.repository.Repository
import com.example.appealscomposetraineeproject.model.repository.RepositoryImpl


class MainViewModel(): ViewModel() {

    private val repository: Repository = RepositoryImpl()
    private var appealLiveData = MutableLiveData<List<Appeal>>()
    val appeals: LiveData<List<Appeal>> = appealLiveData

    var isIncrease by mutableStateOf(true)

    fun getAppeals() {
        appealLiveData.value = repository.getAppeals()
    }

    fun search(input: String) {
        val data = appealLiveData.value as MutableList<Appeal>
        val result: MutableList<Appeal> = listOf<Appeal>().toMutableList()
        result.clear()
        for (item in data) {
            if (
                item.theme.lowercase().contains(input.lowercase()) ||
                item.status.contains(input) ||
                item.number.toString().contains(input) ||
                item.answerForAppeal.contains(input) ||
                item.textOfAppeal.contains(input)
            ) result.add(item)
        }
        appealLiveData.value = result
    }

    fun sortByDate(column: String) {
        val data = appealLiveData.value
        var result: MutableList<Appeal> = listOf<Appeal>().toMutableList()

        if (data != null) {
            if (SortAttributes.DATE.name.equals(column)) {
                result = if (isIncrease) { data.sortedBy { it.date }.toMutableList()
                } else data.sortedByDescending { it.date }.toMutableList()
            }
            else if (SortAttributes.NUMBER.name.equals(column)) {
                result = if (isIncrease) { data.sortedBy { it.number }.toMutableList()
                } else data.sortedByDescending { it.number }.toMutableList()
            }
            else if (SortAttributes.THEME.name.equals(column)) {
                result = if (isIncrease) { data.sortedBy { it.theme }.toMutableList()
                } else data.sortedByDescending { it.theme }.toMutableList()
            }
            else if (SortAttributes.STATUS.name.equals(column)) {
                result = if (isIncrease) { data.sortedBy { it.status }.toMutableList()
                } else data.sortedByDescending { it.status }.toMutableList()
            }

            appealLiveData.value = result
        }
    }
}