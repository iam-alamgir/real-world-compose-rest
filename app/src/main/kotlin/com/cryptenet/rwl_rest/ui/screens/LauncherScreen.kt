package com.cryptenet.rwl_rest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cryptenet.rwl_rest.ui.theme.RealWorldTheme

@Composable
fun LauncherScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface {
            Text(text = "Real World Home")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("articles") }) {
            Text(text = "Goto Next Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()

    RealWorldTheme {
        LauncherScreen(navController = navController)
    }
}
