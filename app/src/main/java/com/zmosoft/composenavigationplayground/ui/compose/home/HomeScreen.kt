package com.zmosoft.composenavigationplayground.ui.compose.home

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    date: Date?
) {
    val dateString = date?.let {
        SimpleDateFormat("M/d/yyyy", Locale.getDefault()).format(it)
    } ?: ""
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1.0f))
        Text(
            text = "Welcome to my app!",
            style = MaterialTheme.typography.h4
        )
        if (dateString.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "The date is $dateString",
                style = MaterialTheme.typography.h6
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    ComposeNavigationPlaygroundTheme {
        HomeScreen(
            date = Date()
        )
    }
}