package com.example.appealscomposetraineeproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appealscomposetraineeproject.model.AppStateAppeals
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.repository.Repository
import com.example.appealscomposetraineeproject.model.repository.RepositoryImpl


class MainViewModel(): ViewModel() {
    val repository: Repository = RepositoryImpl()

    val liveDataObserver : MutableLiveData<AppStateAppeals> = MutableLiveData()


    var isIncrease by mutableStateOf(true)

    fun getLiveData() = liveDataObserver

    fun getAppeals(): List<Appeal> {
        return repository.getAppeals()
    }

    fun sortByDate(data: List<Appeal>): List<Appeal> {
        return if (isIncrease) { data.sortedBy { it.date }
        } else { data.sortedByDescending { it.date } }
    }

    fun search(input: String, data: List<Appeal>): List<Appeal> {
        var result: MutableList<Appeal> = data.toMutableList()
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
        return result
    }

}