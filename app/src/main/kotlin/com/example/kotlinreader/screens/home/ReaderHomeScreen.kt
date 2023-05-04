package com.example.kotlinreader.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReaderAppBar(
    title: String,
    showProfile: Boolean = true,
    navController: NavController,
) {

}

@Composable
fun ReaderHomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            ReaderAppBar(
                title = "",
                navController = navController
            )
        },
        floatingActionButton = {
            FABContent { value ->
                println(value)
            }
        },
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {

        }
    }
}

@Composable
fun FABContent(onTap: (String) -> Unit) {
    FloatingActionButton(
        shape = RoundedCornerShape(50.dp),
        backgroundColor = Color(0xFF92CBDF),
        onClick = { onTap("Alexander") }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a Book",
            tint = Color.White,
        )
    }
}
