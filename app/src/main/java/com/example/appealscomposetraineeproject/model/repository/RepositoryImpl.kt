package com.example.appealscomposetraineeproject.model.repository

import com.example.appealscomposetraineeproject.model.entities.Appeal

class RepositoryImpl: Repository {

    override fun getAppeals(): List<Appeal> = getAppeals()

    override fun sortByDate(list: List<Appeal>, increase: Boolean): List<Appeal> {
        return if (increase) { list.sortedBy { it.date }
        } else { list.sortedByDescending { it.date } }
    }

    override fun search(input: String, list: List<Appeal>): List<Appeal> {
        var result: MutableList<Appeal> = list.toMutableList()
        result.clear()
        for (item in list) {
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