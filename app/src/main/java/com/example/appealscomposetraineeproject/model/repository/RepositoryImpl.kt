package com.example.appealscomposetraineeproject.model.repository

import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.getAppealsLocal


class RepositoryImpl: Repository {

    override fun getAppeals(): List<Appeal> {
        return getAppealsLocal()
    }

    override fun newAppeal() {
        //TODO
    }
}