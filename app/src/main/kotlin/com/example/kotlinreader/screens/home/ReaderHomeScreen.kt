package com.example.kotlinreader.screens.home

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReaderHomeScreen(navController: NavController) {
    Scaffold(
        topBar = {},
        floatingActionButton = {
            FABContent {}
        }
    ) { paddingValues ->

    }
}

@Composable
fun FABContent(onTap: (String) -> Unit) {
    FloatingActionButton(
        shape = RoundedCornerShape(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        onClick = { /*TODO*/ }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a Book",
            tint = MaterialTheme.colors.onSecondary
        )
    }
}
