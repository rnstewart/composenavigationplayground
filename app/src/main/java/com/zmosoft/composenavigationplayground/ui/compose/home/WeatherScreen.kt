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

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Here is today's weather:",
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.weight(1.0f))
    }
}

@Preview
@Composable
fun PreviewWeatherScreen() {
    ComposeNavigationPlaygroundTheme {
        WeatherScreen()
    }
}