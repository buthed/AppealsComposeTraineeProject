package com.example.appealscomposetraineeproject.model.repository

import com.example.appealscomposetraineeproject.model.entities.Appeal

interface Repository {

    fun getAppeals(): List<Appeal>

    fun newAppeal()
}