package com.zmosoft.composenavigationplayground.ui.compose

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Navigation")
                }
            )
        },
        bottomBar = {

        },
        floatingActionButton = {

        },
        content = {

        }
    )
}

@Preview
@Composable
fun PreviewMainScreen() {
    ComposeNavigationPlaygroundTheme {
        MainScreen()
    }
}