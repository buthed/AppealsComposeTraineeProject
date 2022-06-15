package com.example.appealscomposetraineeproject.model

import java.util.*

data class Appeal(
    val date: String,
    val number: Int,
    val theme: String,
    val status: String
)

fun getAppeals() = listOf(
    Appeal("22.03.2021",15203, "Передача показателей", "wait"),
    Appeal("20.02.2021",15202, "Задолженность", "done"),
)