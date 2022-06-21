package com.example.appealscomposetraineeproject.ui.screens.history.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.getAppeals
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppealsTable(data: List<Appeal>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ColumnHeader(Modifier.height(35.dp))
        Divider(color = AppealsComposeTheme.colors.GraySpaces, thickness = 2.dp)
        LazyColumn{
            items(data) { data ->
                var hideRow  by remember { mutableStateOf(false) }
                TableRow(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clickable(
                            onClick = {
                                hideRow = !hideRow
                                Log.d("table", "click " + data.date + " " + hideRow.toString())
                            }
                        ),
                    data)
                Divider(color = AppealsComposeTheme.colors.GraySpaces, thickness = 2.dp)
                AnimatedVisibility(visible = hideRow) {
                    TableAdditionalInfo(
                        Modifier
                            .fillMaxWidth()
                            .animateEnterExit(
                                enter = slideInHorizontally { it },
                                exit = ExitTransition.None
                            ),
                        data)
                }
            }
        }
    }
}

@Composable
fun TableRow(modifier: Modifier = Modifier,
             data: Appeal) {
    Row(
        modifier = modifier,
        Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TableText(Modifier.weight(1f),data.date)
        TableText(Modifier.weight(1f),data.number.toString())
        TableText(Modifier.weight(1f),data.theme)
        TableText(Modifier.weight(1f),data.status)
    }
}

@Composable
fun TableAdditionalInfo(
    modifier: Modifier = Modifier.fillMaxWidth(),
    data: Appeal
) {
    Surface(Modifier.fillMaxWidth()) {
        Column(Modifier.fillMaxWidth()) {
            Row(
                Modifier
                    .fillMaxWidth()
            ) {
                TableText(
                    Modifier
                        .weight(1f)
                        .padding(top = 50.dp),
                    data.date,
                    style = TextStyle(color = AppealsComposeTheme.colors.GrayStatus)
                )
                Box(Modifier.weight(3f)) {
                    Column() {
                        AdditionalInfoRow(stringResource(R.string.ah_themes_title), data.theme)
                        AdditionalInfoRow(stringResource(R.string.ah_text_of_appeal), data.textOfAppeal)
                        AdditionalInfoRow(stringResource(R.string.ah_text_of_answer), data.answerForAppeal)
                    }
                }
            }
            Spacer(Modifier.height(25.dp))
            Box(){
                Row(Modifier.padding(start = 17.dp)) {
                    AdditionalTitleTable(
                        modifier = Modifier.weight(2f),
                        text = stringResource(R.string.ah_attached_files))
                    HyperlinkText(
                        modifier = Modifier.weight(3f),
                        fullText = stringResource(R.string.ah_attached_files_link),
                        linkText = listOf(stringResource(R.string.ah_attached_files_link)),
                        hyperlinks = listOf("https://ru.wikipedia.org/wiki/%D0%A4%D0%B0%D0%B9%D0%BB"),
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun AdditionalInfoRow(title: String, text: String) {
    Row() {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )) {
                    append(title)
                }
                append(": ")
                withStyle(style = SpanStyle(
                    fontSize = 10.sp,
                    fontStyle = AppealsComposeTheme.typography.smallSmallTableText.fontStyle
                )
                ){
                    append(text)
                }

            }
        )
    }
    Spacer(Modifier.height(3.dp))
}

@Composable
fun AdditionalTitleTable(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold)
}

@Composable
fun ColumnHeader(
    modifier: Modifier = Modifier,
    model: MainViewModel = viewModel()
){
    Row(
        modifier = modifier,
        Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TableTextColumnName(Modifier.weight(1f).clickable{
            model.isIncrease = !model.isIncrease

            Log.d("click", model.isIncrease.toString())
        },stringResource(R.string.ah_date))
        TableTextColumnName(Modifier.weight(1f),stringResource(R.string.ah_number))
        TableTextColumnName(Modifier.weight(1f),stringResource(R.string.ah_themes))
        TableTextColumnName(Modifier.weight(1f),stringResource(R.string.ah_status))
    }
}

@Composable
fun TableTextColumnName(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = AppealsComposeTheme.typography.columnName
){
    Text(
        text = text,
        modifier = modifier,
        textAlign = TextAlign.Center,
        style = style
    )
}

@Composable
fun TableText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = AppealsComposeTheme.typography.tableText
){
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        style = style
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealsTable() {
    val data = getAppeals()
    MainTheme {
        AppealsTable(data)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewTableRowAdditionalInfo() {
    val data = Appeal("22.03.2021",15203, "Передача показателей", "wait", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.")
    MainTheme {
        TableAdditionalInfo(
            Modifier.fillMaxWidth(),
            data)
    }
}