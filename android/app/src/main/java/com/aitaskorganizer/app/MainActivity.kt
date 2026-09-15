package com.aitaskorganizer.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aitaskorganizer.app.navigation.AppBottomNavBar
import com.aitaskorganizer.app.navigation.AppNavHost
import com.aitaskorganizer.app.navigation.Screen
import com.aitaskorganizer.app.ui.theme.AITaskOrganizerTheme

/**
 * Single Activity host for the entire Compose UI.
 *
 * Uses a Scaffold with:
 * - AppNavHost for screen content
 * - AppBottomNavBar for tab navigation
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AITaskOrganizerTheme {
                AITaskOrganizerApp()
            }
        }
    }
}

/**
 * Root composable for the application.
 *
 * Manages the NavController and wires up the bottom navigation
 * with the NavHost content area.
 */
@Composable
fun AITaskOrganizerApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    // Bottom nav tabs — used to determine if bottom bar is visible
    val bottomNavRoutes = setOf(
        Screen.Home.route,
        Screen.Tasks.route,
        Screen.AIInbox.route,
        Screen.Completed.route,
        Screen.Settings.route
    )
    val currentRoute = backStackEntry?.destination?.route
    val showBottomBar = currentRoute in bottomNavRoutes

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AppBottomNavBar(
                currentBackStackEntry = backStackEntry,
                onTabSelected = { screen ->
                    navController.navigate(screen.route) {
                        // Pop up to the start destination to avoid building up a
                        // large stack of destinations on the back stack
                        popUpTo(Screen.Home.route) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected tab
                        restoreState = true
                    }
                },
                visible = showBottomBar
            )
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AITaskOrganizerAppPreview() {
    AITaskOrganizerTheme {
        AITaskOrganizerApp()
    }
}
