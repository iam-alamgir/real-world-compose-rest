package com.cryptenet.rwl_rest.ui.navigation

sealed class AppScreen(val route: String) {
    object LauncherScreen: AppScreen("launcher_screen")
}
