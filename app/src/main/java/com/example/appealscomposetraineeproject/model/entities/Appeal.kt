package com.example.appealscomposetraineeproject.model.entities

import androidx.compose.runtime.State
import androidx.lifecycle.MutableLiveData

data class Appeal(
    val date: String,
    val number: Int,
    val theme: String,
    val status: String,
    val textOfAppeal: String,
    val answerForAppeal: String,
    val attachments: List<String>
)

enum class SortAttributes{
    DATE,
    NUMBER,
    THEME,
    STATUS
}

fun getAppealsLocal(): List<Appeal> = listOf(
    Appeal("22.03.2021",15203, "Передача показателей", "wait", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf("https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",
            "https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",)),
    Appeal("21.02.2021",15201, "Начисление ОДН", "done", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf("https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",)),
    Appeal("19.12.2022",15200, "Задолженность", "done", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf()),
    Appeal("20.02.2021",15202, "Задолженность", "wait", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf("https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",)),
)