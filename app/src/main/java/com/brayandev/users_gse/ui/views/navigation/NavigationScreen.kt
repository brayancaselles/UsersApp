package com.brayandev.users_gse.ui.views.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.brayandev.users_gse.ui.views.splash.SplashScreen
import com.brayandev.users_gse.ui.views.userDetail.UserDetailScreen
import com.brayandev.users_gse.ui.views.userDetail.UserDetailViewModel
import com.brayandev.users_gse.ui.views.users.UsersScreen
import com.brayandev.users_gse.ui.views.users.UsersViewModel

@Composable
fun NavigationScreen() {
    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = Routes.SplashScreen.route) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController = navigationController)
        }
        composable(Routes.Home.route) {
            val viewModel = hiltViewModel<UsersViewModel>()
            UsersScreen(navController = navigationController, viewModel)
        }
        composable(
            Routes.UserDetail.route,
            arguments = listOf(navArgument(USER_ID) { type = NavType.IntType }),
        ) {
            val viewModel = hiltViewModel<UserDetailViewModel>()
            UserDetailScreen(viewModel = viewModel)
        }
    }
}
