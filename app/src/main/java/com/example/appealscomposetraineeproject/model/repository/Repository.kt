package com.example.appealscomposetraineeproject.model.repository

import com.example.appealscomposetraineeproject.model.entities.Appeal

interface Repository {

    fun getAppeals(): List<Appeal>

    fun sortByDate(list: List<Appeal>, increase: Boolean): List<Appeal>

    fun search(input: String, list: List<Appeal>): List<Appeal>
}