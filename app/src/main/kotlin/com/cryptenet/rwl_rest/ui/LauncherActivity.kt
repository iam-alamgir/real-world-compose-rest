package com.cryptenet.rwl_rest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.cryptenet.rwl_rest.ui.navigation.AppNavigator
import com.cryptenet.rwl_rest.ui.theme.RealWorldTheme

class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            RealWorldTheme {
                AppNavigator()
            }
        }
    }
}
