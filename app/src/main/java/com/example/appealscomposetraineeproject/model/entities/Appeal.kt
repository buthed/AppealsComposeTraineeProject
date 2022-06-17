package com.example.appealscomposetraineeproject.model.entities

data class Appeal(
    val date: String,
    val number: Int,
    val theme: String,
    val status: String
)

fun getAppeals() = listOf(
    Appeal("22.03.2021",15203, "Передача показателей", "wait"),
    Appeal("21.02.2021",15201, "Начисление ОДН", "done"),
    Appeal("20.02.2021",15202, "Задолженность", "wait"),
    Appeal("19.12.2022",15200, "Задолженность", "done"),
)