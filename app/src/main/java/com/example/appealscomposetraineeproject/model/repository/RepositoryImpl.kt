package com.example.appealscomposetraineeproject.model.repository

import com.example.appealscomposetraineeproject.model.entities.Appeal

class RepositoryImpl: Repository {

    override fun getAppeals(): List<Appeal> = getAppeals()
}