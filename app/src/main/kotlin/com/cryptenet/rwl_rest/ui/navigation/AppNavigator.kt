package com.cryptenet.rwl_rest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.dynamicfeatures.createGraph
import androidx.navigation.dynamicfeatures.includeDynamic
import com.cryptenet.rwl_rest.BuildConfig
import com.cryptenet.rwl_rest.ui.screens.LauncherScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        graph = navController.createGraph(
            startDestination = AppScreen.LauncherScreen.route,
        ) {
            composable(route = AppScreen.LauncherScreen.route) {
                LauncherScreen(navController = navController)
            }

            includeDynamic(
                route = "${BuildConfig.FEATURE_NAMES[0]}_screen",
                moduleName = BuildConfig.FEATURE_MODULE_NAMES[0],
                graphResourceName = "articlesGraph"
            )
        }
    )
}
