package com.brayandev.users_gse.ui.views.navigation

const val USER_ID = "userId"

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash")
    object Home : Routes("home")
    object UserDetail : Routes("userDetail/{$USER_ID}") {
        fun createRoute(userId: Int): String {
            return "userDetail/$userId"
        }
    }
}
