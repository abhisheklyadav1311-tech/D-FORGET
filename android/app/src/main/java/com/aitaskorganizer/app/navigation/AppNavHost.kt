package com.aitaskorganizer.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aitaskorganizer.app.ui.completed.CompletedScreen
import com.aitaskorganizer.app.ui.home.HomeScreen
import com.aitaskorganizer.app.ui.inbox.InboxScreen
import com.aitaskorganizer.app.ui.settings.SettingsScreen
import com.aitaskorganizer.app.ui.tasks.TasksScreen

/**
 * Main navigation host for the application.
 *
 * Contains routes for:
 * - 5 bottom-nav tab destinations
 * - Detail screens (added in later phases)
 *
 * @param navController The navigation controller
 * @param modifier Modifier for the NavHost container
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        // ── Bottom Nav Tabs ────────────────────────────────

        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToTaskDetail = { taskId ->
                    navController.navigate(Screen.TaskDetail.createRoute(taskId))
                },
                onNavigateToAddTask = {
                    navController.navigate(Screen.AddTask.route)
                },
                onNavigateToAIInbox = {
                    navController.navigate(Screen.AIInbox.route) {
                        popUpTo(Screen.Home.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

        composable(Screen.Tasks.route) {
            TasksScreen(
                onNavigateToTaskDetail = { taskId ->
                    navController.navigate(Screen.TaskDetail.createRoute(taskId))
                },
                onNavigateToAddTask = {
                    navController.navigate(Screen.AddTask.route)
                }
            )
        }

        composable(Screen.AIInbox.route) {
            InboxScreen(
                onNavigateToAnalysisResult = { sourceId ->
                    navController.navigate(Screen.AIAnalysisResult.createRoute(sourceId))
                },
                onNavigateToPasteText = {
                    navController.navigate(Screen.PasteText.route)
                }
            )
        }

        composable(Screen.Completed.route) {
            CompletedScreen(
                onNavigateToTaskDetail = { taskId ->
                    navController.navigate(Screen.TaskDetail.createRoute(taskId))
                }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen()
        }

        // ── Detail Screens (Phase 5+) ──────────────────────
        // TaskDetail, AddTask, EditTask, AIAnalysisResult,
        // AILoading, SourceDetail, PasteText
        // will be added in their respective phases.
    }
}
