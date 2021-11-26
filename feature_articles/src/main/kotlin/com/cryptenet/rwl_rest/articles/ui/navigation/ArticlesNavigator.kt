package com.cryptenet.rwl_rest.articles.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import androidx.navigation.navigation
import com.cryptenet.rwl_rest.articles.ui.screens.ArticlesScreen

fun NavGraphBuilder.articlesGraph(navController: NavController) {
    navigation(
        startDestination = "articles",
        route = "articles"
    ) {
        composable("articles") {
            ArticlesScreen(navController = navController)
        }
    }
}

@Composable
fun ArticlesNavigator() {
    val navController = rememberNavController()
    
    NavHost(navController = navController,
        graph = navController.createGraph(
            startDestination = ArticleScreen.ArticlesScreen.route
        ) {
            composable(ArticleScreen.ArticlesScreen.route) {
                ArticlesScreen(navController = navController)
            }
        }
    )
}
