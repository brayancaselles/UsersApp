package com.brayandev.users_gse.ui.views.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationScreen() {
    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = Routes.SplashScreen.route) {
        composable(Routes.SplashScreen.route) {
        }
        composable(Routes.Home.route) {
        }
        composable(
            Routes.UserDetail.route,
            arguments = listOf(navArgument(USER_ID) { type = NavType.IntType }),
        ) {}
    }
}
