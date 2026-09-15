package com.aitaskorganizer.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.Checklist
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Tune
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Data class representing a bottom navigation item.
 */
data class BottomNavItem(
    val screen: Screen,
    val label: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

/**
 * The 5 bottom navigation tabs per PRD specification.
 *
 * Tab order: Home | Tasks | AI Inbox | Done | Settings
 * AI Inbox is the center tab — visually prominent.
 */
val bottomNavItems = listOf(
    BottomNavItem(
        screen = Screen.Home,
        label = "Home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home
    ),
    BottomNavItem(
        screen = Screen.Tasks,
        label = "Tasks",
        unselectedIcon = Icons.Outlined.Checklist,
        selectedIcon = Icons.Filled.Checklist
    ),
    BottomNavItem(
        screen = Screen.AIInbox,
        label = "AI Inbox",
        unselectedIcon = Icons.Outlined.AutoAwesome,
        selectedIcon = Icons.Filled.AutoAwesome
    ),
    BottomNavItem(
        screen = Screen.Completed,
        label = "Done",
        unselectedIcon = Icons.Outlined.CheckCircleOutline,
        selectedIcon = Icons.Filled.CheckCircle
    ),
    BottomNavItem(
        screen = Screen.Settings,
        label = "Settings",
        unselectedIcon = Icons.Outlined.Tune,
        selectedIcon = Icons.Filled.Tune
    )
)
