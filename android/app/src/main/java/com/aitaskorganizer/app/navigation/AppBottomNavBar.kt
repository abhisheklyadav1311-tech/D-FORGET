package com.aitaskorganizer.app.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry

/**
 * Bottom navigation bar for AI Task Organizer.
 *
 * 5 tabs: Home | Tasks | AI Inbox | Done | Settings
 *
 * The AI Inbox tab uses the secondary (violet) color to
 * visually distinguish it as the AI feature entry point.
 *
 * @param currentBackStackEntry Current navigation back stack entry for selection state
 * @param onTabSelected Callback when a tab is tapped
 * @param visible Whether the bottom bar should be visible (hidden on detail screens)
 */
@Composable
fun AppBottomNavBar(
    currentBackStackEntry: NavBackStackEntry?,
    onTabSelected: (Screen) -> Unit,
    visible: Boolean = true
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            tonalElevation = 2.dp
        ) {
            val currentRoute = currentBackStackEntry?.destination?.route

            bottomNavItems.forEach { item ->
                val isSelected = currentRoute == item.screen.route
                val isAIInbox = item.screen == Screen.AIInbox

                NavigationBarItem(
                    selected = isSelected,
                    onClick = { onTabSelected(item.screen) },
                    icon = {
                        Icon(
                            imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                            contentDescription = item.label,
                            modifier = Modifier.size(if (isAIInbox) 26.dp else 24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.label,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = if (isAIInbox) {
                            MaterialTheme.colorScheme.secondary
                        } else {
                            MaterialTheme.colorScheme.primary
                        },
                        selectedTextColor = if (isAIInbox) {
                            MaterialTheme.colorScheme.secondary
                        } else {
                            MaterialTheme.colorScheme.primary
                        },
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = if (isAIInbox) {
                            MaterialTheme.colorScheme.secondaryContainer
                        } else {
                            MaterialTheme.colorScheme.primaryContainer
                        }
                    )
                )
            }
        }
    }
}
