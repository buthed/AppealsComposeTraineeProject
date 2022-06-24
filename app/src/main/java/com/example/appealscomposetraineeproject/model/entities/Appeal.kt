package com.example.appealscomposetraineeproject.model.entities

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.lifecycle.MutableLiveData
import java.time.LocalDate

data class Appeal(
    val date: LocalDate,
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

@RequiresApi(Build.VERSION_CODES.O)
fun getAppealsLocal(): List<Appeal> = listOf(
    Appeal(LocalDate.of(2021,3,22),15203, "Передача показателей", "wait", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf("https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",
            "https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",)),
    Appeal(LocalDate.of(2021,2,21),15201, "Начисление ОДН", "done", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf("https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",)),
    Appeal(LocalDate.of(2022,12,19),15200, "Задолженность", "done", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf()),
    Appeal(LocalDate.of(2021,2,20),15202, "Задолженность", "wait", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf("https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",)),
)