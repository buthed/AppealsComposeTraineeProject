package com.example.appealscomposetraineeproject.ui.screens.history.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appealscomposetraineeproject.R
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.getAppeals
import com.example.appealscomposetraineeproject.ui.theme.AppealsComposeTheme
import com.example.appealscomposetraineeproject.ui.theme.MainTheme

@Composable
fun AppealsTable() {
    val data = getAppeals()
    AppealsTable1(data = data)

}

@Composable
fun AppealsTable1(data: List<Appeal>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.height(35.dp),
            Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TableTextColumName(Modifier.weight(1f),stringResource(R.string.ah_date))
            TableTextColumName(Modifier.weight(1f),stringResource(R.string.ah_number))
            TableTextColumName(Modifier.weight(1f),stringResource(R.string.ah_themes))
            TableTextColumName(Modifier.weight(1f),stringResource(R.string.ah_status))
        }
        Divider(color = AppealsComposeTheme.colors.GraySpaces, thickness = 2.dp)
        LazyColumn{
            items(data) { data ->
                Row(
                    Modifier.fillMaxWidth().height(50.dp),
                    Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TableText(Modifier.weight(1f),data.date)
                    TableText(Modifier.weight(1f),data.number.toString())
                    TableText(Modifier.weight(1f),data.theme)
                    TableText(Modifier.weight(1f),data.status)
                }
                Divider(color = AppealsComposeTheme.colors.GraySpaces, thickness = 2.dp)
            }
        }
    }
}

@Composable
fun TableTextColumName(
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
    MainTheme {
        AppealsTable()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAppealsTable2() {
    MainTheme {
        AppealsTable()
    }
}