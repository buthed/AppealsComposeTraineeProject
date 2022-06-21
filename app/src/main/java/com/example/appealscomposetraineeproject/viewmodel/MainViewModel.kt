package com.example.appealscomposetraineeproject.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appealscomposetraineeproject.model.AppStateAppeals
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.repository.Repository
import com.example.appealscomposetraineeproject.model.repository.RepositoryImpl


class MainViewModel(
    val liveDataObserver : MutableLiveData<AppStateAppeals> = MutableLiveData(),
    val repository: Repository = RepositoryImpl()
): ViewModel() {

    var isIncrease by mutableStateOf(true)

    fun getLiveData() = liveDataObserver

    fun getAppeals(): List<Appeal> {
        return repository.getAppeals()
    }

    fun sortByDate(data: List<Appeal>,isIncrease: Boolean): List<Appeal> {
        return repository.sortByDate(data, isIncrease)
    }

    fun search(input: String, data: List<Appeal>): List<Appeal> {
        return repository.search(input, data)
    }

}