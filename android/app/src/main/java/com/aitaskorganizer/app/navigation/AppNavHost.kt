package com.aitaskorganizer.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aitaskorganizer.app.AITaskOrganizerApplication
import com.aitaskorganizer.app.di.NetworkModule
import com.aitaskorganizer.app.di.RepositoryModule
import com.aitaskorganizer.app.ui.analysis.AnalysisResultScreen
import com.aitaskorganizer.app.ui.analysis.viewmodel.AnalysisViewModelFactory
import com.aitaskorganizer.app.ui.completed.CompletedScreen
import com.aitaskorganizer.app.ui.home.HomeScreen
import com.aitaskorganizer.app.ui.home.viewmodel.HomeViewModel
import com.aitaskorganizer.app.ui.home.viewmodel.HomeViewModelFactory
import com.aitaskorganizer.app.ui.inbox.InboxScreen
import com.aitaskorganizer.app.ui.inbox.PasteTextScreen
import com.aitaskorganizer.app.ui.inbox.viewmodel.InboxViewModel
import com.aitaskorganizer.app.ui.inbox.viewmodel.InboxViewModelFactory
import com.aitaskorganizer.app.ui.settings.SettingsScreen
import com.aitaskorganizer.app.ui.source.SourceTransparencyScreen
import com.aitaskorganizer.app.ui.source.viewmodel.SourceDetailViewModelFactory
import com.aitaskorganizer.app.ui.tasks.EditTaskScreen
import com.aitaskorganizer.app.ui.tasks.TaskDetailScreen
import com.aitaskorganizer.app.ui.tasks.TasksScreen
import com.aitaskorganizer.app.ui.tasks.viewmodel.EditTaskViewModel
import com.aitaskorganizer.app.ui.tasks.viewmodel.EditTaskViewModelFactory
import com.aitaskorganizer.app.ui.tasks.viewmodel.TaskDetailViewModel
import com.aitaskorganizer.app.ui.tasks.viewmodel.TaskDetailViewModelFactory
import com.aitaskorganizer.app.ui.tasks.viewmodel.TasksViewModel
import com.aitaskorganizer.app.ui.tasks.viewmodel.TasksViewModelFactory

/**
 * Main navigation host for the application.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val app = context.applicationContext as AITaskOrganizerApplication
    val repository = app.taskRepository
    val reminderRepository = app.reminderRepository

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        // ── Bottom Nav Tabs ────────────────────────────────

        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModelFactory(repository)
            )
            HomeScreen(
                viewModel = homeViewModel,
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
            val tasksViewModel: TasksViewModel = viewModel(
                factory = TasksViewModelFactory(repository)
            )
            TasksScreen(
                viewModel = tasksViewModel,
                onNavigateToTaskDetail = { taskId ->
                    navController.navigate(Screen.TaskDetail.createRoute(taskId))
                },
                onNavigateToAddTask = {
                    navController.navigate(Screen.AddTask.route)
                }
            )
        }

        composable(Screen.AIInbox.route) {
            val inboxViewModel: InboxViewModel = viewModel(
                factory = InboxViewModelFactory(RepositoryModule.sourceRepository)
            )
            InboxScreen(
                viewModel = inboxViewModel,
                onNavigateToAnalysisResult = { sourceId ->
                    navController.navigate(Screen.AIAnalysisResult.createRoute(sourceId))
                },
                onNavigateToPasteText = {
                    navController.navigate(Screen.PasteText.route)
                }
            )
        }

        composable(Screen.PasteText.route) {
            val inboxViewModel: InboxViewModel = viewModel(
                factory = InboxViewModelFactory(RepositoryModule.sourceRepository)
            )
            PasteTextScreen(
                viewModel = inboxViewModel,
                onBack = { navController.popBackStack() },
                onSuccess = { sourceId ->
                    navController.navigate(Screen.AIAnalysisResult.createRoute(sourceId)) {
                        popUpTo(Screen.AIInbox.route)
                    }
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

        // ── Detail Screens ──────────────────────
        composable(
            route = Screen.AIAnalysisResult.route,
            arguments = listOf(
                navArgument(Screen.AIAnalysisResult.ARG_SOURCE_ID) { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val sourceId = backStackEntry.arguments?.getLong(Screen.AIAnalysisResult.ARG_SOURCE_ID) ?: 0L
            AnalysisResultScreen(
                sourceId = sourceId,
                viewModel = viewModel(
                    factory = AnalysisViewModelFactory(
                        sourceApi = NetworkModule.sourceApi,
                        taskRepository = repository
                    )
                ),
                onBackClick = { navController.popBackStack() },
                onViewSource = { id ->
                    navController.navigate(Screen.SourceDetail.createRoute(id))
                }
            )
        }

        composable(
            route = Screen.SourceDetail.route,
            arguments = listOf(
                navArgument(Screen.SourceDetail.ARG_SOURCE_ID) { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val sourceId = backStackEntry.arguments?.getLong(Screen.SourceDetail.ARG_SOURCE_ID) ?: 0L
            SourceTransparencyScreen(
                viewModel = viewModel(
                    factory = SourceDetailViewModelFactory(
                        repository = RepositoryModule.sourceRepository,
                        sourceId = sourceId
                    )
                ),
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.TaskDetail.route,
            arguments = listOf(
                navArgument(Screen.TaskDetail.ARG_TASK_ID) { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getLong(Screen.TaskDetail.ARG_TASK_ID) ?: 0L
            val detailViewModel: TaskDetailViewModel = viewModel(
                factory = TaskDetailViewModelFactory(repository, taskId)
            )
            TaskDetailScreen(
                viewModel = detailViewModel,
                onBack = { navController.popBackStack() },
                onEdit = { id -> navController.navigate(Screen.EditTask.createRoute(id)) },
                onDeleted = { navController.popBackStack() }
            )
        }

        composable(Screen.AddTask.route) {
            val editViewModel: EditTaskViewModel = viewModel(
                factory = EditTaskViewModelFactory(repository, reminderRepository, 0L)
            )
            EditTaskScreen(
                viewModel = editViewModel,
                onBack = { navController.popBackStack() },
                onSaved = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.EditTask.route,
            arguments = listOf(
                navArgument(Screen.EditTask.ARG_TASK_ID) { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getLong(Screen.EditTask.ARG_TASK_ID) ?: 0L
            val editViewModel: EditTaskViewModel = viewModel(
                factory = EditTaskViewModelFactory(repository, reminderRepository, taskId)
            )
            EditTaskScreen(
                viewModel = editViewModel,
                onBack = { navController.popBackStack() },
                onSaved = { navController.popBackStack() }
            )
        }
    }
}
