package com.example.appealscomposetraineeproject.model

import com.example.appealscomposetraineeproject.model.entities.Appeal

sealed class AppStateAppeals {
    data class Success(val cameraData: List<Appeal>) : AppStateAppeals()
    data class Error(val error: Throwable) : AppStateAppeals()
    object Loading : AppStateAppeals()
}