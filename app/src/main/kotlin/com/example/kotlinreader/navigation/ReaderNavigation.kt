package com.example.kotlinreader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinreader.screens.ReaderSplashScreen
import com.example.kotlinreader.screens.details.BookDetailsScreen
import com.example.kotlinreader.screens.home.ReaderHomeScreen
import com.example.kotlinreader.screens.login.ReaderLoginScreen
import com.example.kotlinreader.screens.search.ReaderBookSearchScreen
import com.example.kotlinreader.screens.signup.ReaderSignupScreen
import com.example.kotlinreader.screens.stats.ReaderStatsScreen
import com.example.kotlinreader.screens.update.ReaderBookUpdateScreen

@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ReaderScreens.SplashScreen.name
    ) {
        composable(ReaderScreens.SplashScreen.name) {
            ReaderSplashScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name) {
            ReaderLoginScreen(navController = navController)
        }

        composable(ReaderScreens.CreateAccountScreen.name) {
            ReaderSignupScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderHomeScreen.name) {
            ReaderHomeScreen(navController = navController)
        }

        composable(ReaderScreens.SearchScreen.name) {
            ReaderBookSearchScreen(navController = navController)
        }

        composable(ReaderScreens.DetailScreen.name) {
            BookDetailsScreen(navController = navController)
        }

        composable(ReaderScreens.UpdateScreen.name) {
            ReaderBookUpdateScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderStatsScreen.name) {
            ReaderStatsScreen(navController = navController)
        }
    }
}