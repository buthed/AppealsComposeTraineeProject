package com.example.appealscomposetraineeproject.ui.screens.history.components

import android.net.Uri
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.appealscomposetraineeproject.model.entities.SortAttributes
import com.example.appealscomposetraineeproject.model.entities.getAppealsLocal
import com.example.appealscomposetraineeproject.ui.screens.history.AppealHistoryScreenCallback
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppealsTable(data: List<Appeal>, model: MainViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ColumnHeader(Modifier.height(35.dp), model)
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
        val context = LocalContext.current
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
                Row(
                    modifier = Modifier.padding(start = 17.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    AdditionalTitleTable(
                        modifier = Modifier.weight(2f),
                        text = stringResource(R.string.ah_attached_files))
                    data.attachments.forEach() { item ->

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    val builder = CustomTabsIntent.Builder()
                                    val customTabsIntent = builder.build()
                                    customTabsIntent.launchUrl(context, Uri.parse(item))
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                tint = AppealsComposeTheme.colors.GrayLabel,
                                painter = painterResource(R.drawable.icon_pdf),
                                contentDescription = "1"
                            )
                            Text(
                                text = stringResource(R.string.ah_pdf),
                                fontSize = 10.sp
                            )
                        }
                    }
                    HyperlinkText(
                        modifier = Modifier.weight(3f),
                        fullText = stringResource(R.string.ah_attached_files_link),
                        linkText = listOf(stringResource(R.string.ah_attached_files_link)),
                        hyperlinks = listOf(stringResource(R.string.ah_link)),
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
    model: MainViewModel
){
    Row(
        modifier = modifier,
        Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TableTextColumnName(
            Modifier
                .weight(1f)
                .clickable {
                    model.isIncrease = !model.isIncrease
                    model.sortByDate(SortAttributes.DATE)
                    Log.d("click", model.isIncrease.toString())
                },stringResource(R.string.ah_date))
        TableTextColumnName(
            Modifier
                .weight(1f)
                .clickable {
                    model.isIncrease = !model.isIncrease
                    model.sortByDate(SortAttributes.NUMBER)
                    Log.d("click", model.isIncrease.toString())
                },stringResource(R.string.ah_number))
        TableTextColumnName(
            Modifier
                .weight(1f)
                .clickable {
                    model.isIncrease = !model.isIncrease
                    model.sortByDate(SortAttributes.THEME)
                    Log.d("click", model.isIncrease.toString())
                },stringResource(R.string.ah_themes))
        TableTextColumnName(
            Modifier
                .weight(1f)
                .clickable {
                    model.isIncrease = !model.isIncrease
                    model.sortByDate(SortAttributes.STATUS)
                    Log.d("click", model.isIncrease.toString())
                },stringResource(R.string.ah_status))
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
    val data = getAppealsLocal()
    val model: MainViewModel = viewModel()
    MainTheme {
        AppealsTable(data, model)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewTableRowAdditionalInfo() {
    val data =  Appeal("22.03.2021",15203, "Передача показателей", "wait", "В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.","В квитанции за январь у меня не правильно отражаются показания, последний раз\n" +
            "я передавал показания 20.01.2021 года 5516, а в квитанции 5550. Прошу Вас разобраться в данной ситуации.",
        listOf("chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",
            "chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf",))
    MainTheme {
        TableAdditionalInfo(
            Modifier.fillMaxWidth(),
            data)
    }
}