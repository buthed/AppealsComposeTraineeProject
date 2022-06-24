package com.example.appealscomposetraineeproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.SortAttributes
import com.example.appealscomposetraineeproject.model.repository.Repository
import com.example.appealscomposetraineeproject.model.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(): ViewModel() {

    private val repository: Repository = RepositoryImpl()
    private var appealLiveData = MutableLiveData<List<Appeal>>()
    val appeals: LiveData<List<Appeal>> = appealLiveData

    var isIncrease by mutableStateOf(true)

    fun getAppeals() {
        viewModelScope.launch(Dispatchers.IO) {
            appealLiveData.postValue(
                repository.getAppeals()
            )
        }
        appealLiveData.value = repository.getAppeals()
    }

    fun search(input: String) {
        val data = appealLiveData.value ?: return
        val result = mutableListOf<Appeal>()
        for (item in data) {
            if (
                item.theme.lowercase().contains(input.lowercase()) ||
                item.status.contains(input) ||
                item.number.toString().contains(input) ||
                item.answerForAppeal.contains(input) ||
                item.textOfAppeal.contains(input)
            ) result.add(item)
        }
//        data.filter {
//            it.theme.lowercase().contains(input.lowercase()) ||
//                    it.status.contains(input.lowercase()) ||
//                    it.number.toString().contains(input.lowercase()) ||
//                    it.answerForAppeal.contains(input.lowercase()) ||
//                    it.textOfAppeal.contains(input.lowercase())
//        }
        appealLiveData.value = result
    }

    fun sortByDate(column: SortAttributes) {
        val data = appealLiveData.value ?: return
        isIncrease = !isIncrease
        fun <R: Comparable<R>> sort(selector: (Appeal) -> R): List<Appeal> =
            if (isIncrease)  data.sortedBy(selector)
            else data.sortedByDescending(selector)

        appealLiveData.value = when(column) {
            SortAttributes.DATE -> sort { it.date }
            SortAttributes.NUMBER -> sort { it.number }
            SortAttributes.THEME -> sort { it.theme }
            SortAttributes.STATUS -> sort { it.status }
        }
    }
}