package com.aitaskorganizer.app.navigation

/**
 * All navigation destinations in the app.
 *
 * Bottom-nav tabs use simple routes.
 * Detail screens use parameterized routes with arguments.
 */
sealed class Screen(val route: String) {

    // ── Bottom Navigation Tabs ─────────────────────────────
    data object Home : Screen("home")
    data object Tasks : Screen("tasks")
    data object AIInbox : Screen("ai_inbox")
    data object Completed : Screen("completed")
    data object Settings : Screen("settings")

    // ── Detail Screens (implemented in later phases) ───────
    data object TaskDetail : Screen("task_detail/{taskId}") {
        fun createRoute(taskId: Long) = "task_detail/$taskId"
        const val ARG_TASK_ID = "taskId"
    }

    data object AddTask : Screen("add_task")

    data object EditTask : Screen("edit_task/{taskId}") {
        fun createRoute(taskId: Long) = "edit_task/$taskId"
        const val ARG_TASK_ID = "taskId"
    }

    data object AIAnalysisResult : Screen("ai_analysis_result/{sourceId}") {
        fun createRoute(sourceId: Long) = "ai_analysis_result/$sourceId"
        const val ARG_SOURCE_ID = "sourceId"
    }

    data object AILoading : Screen("ai_loading")

    data object SourceDetail : Screen("source_detail/{sourceId}") {
        fun createRoute(sourceId: Long) = "source_detail/$sourceId"
        const val ARG_SOURCE_ID = "sourceId"
    }

    data object PasteText : Screen("paste_text")
}
