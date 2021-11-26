package com.cryptenet.rwl_rest.articles.ui.navigation

sealed class ArticleScreen (val route: String) {
    object ArticlesScreen: ArticleScreen("articles_screen")
}