package com.cryptenet.rwl_rest.articles.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.cryptenet.rwl_rest.articles.ui.navigation.ArticlesNavigator
import com.cryptenet.rwl_rest.ui.theme.RealWorldTheme

@Composable
fun ArticlesScreen(navController: NavController) {
    ArticlesNavigator()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RealWorldTheme {
        ArticlesNavigator()
    }
}