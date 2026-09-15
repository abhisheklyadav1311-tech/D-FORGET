package com.aitaskorganizer.app.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.data.mock.MockData
import com.aitaskorganizer.app.data.model.TaskUiModel
import com.aitaskorganizer.app.ui.components.MetricCard
import com.aitaskorganizer.app.ui.components.TaskCard
import com.aitaskorganizer.app.ui.theme.AITaskOrganizerTheme
import com.aitaskorganizer.app.ui.theme.AppDimens
import java.time.LocalTime

/**
 * Home Dashboard screen.
 *
 * Answers: "What do I need to do today?"
 *
 * Sections:
 * 1. Greeting
 * 2. Metric cards (Today / Upcoming / Overdue)
 * 3. AI Inbox card (prominent, violet-themed)
 * 4. Today's tasks
 */
@Composable
fun HomeScreen(
    onNavigateToTaskDetail: (Long) -> Unit = {},
    onNavigateToAddTask: () -> Unit = {},
    onNavigateToAIInbox: () -> Unit = {}
) {
    // Mock data — will be replaced by ViewModel in Phase 12
    val todayTasks = MockData.todayTasks
    val upcomingCount = MockData.upcomingTasks.size
    val overdueCount = MockData.overdueTasks.size
    val aiInboxCount = MockData.aiInboxCount

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToAddTask,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(AppDimens.CornerRadiusMedium)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add new task"
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = AppDimens.ScreenHorizontalPadding,
                end = AppDimens.ScreenHorizontalPadding,
                top = AppDimens.ScreenTopPadding,
                bottom = 80.dp // Space for FAB
            ),
            verticalArrangement = Arrangement.spacedBy(AppDimens.CardSpacing)
        ) {
            // ── Greeting ───────────────────────────────────
            item {
                GreetingSection()
            }

            // ── Metric Cards ───────────────────────────────
            item {
                MetricCardsRow(
                    todayCount = todayTasks.size,
                    upcomingCount = upcomingCount,
                    overdueCount = overdueCount
                )
            }

            // ── AI Inbox Card ──────────────────────────────
            item {
                AIInboxCard(
                    pendingCount = aiInboxCount,
                    onClick = onNavigateToAIInbox
                )
            }

            // ── Today's Tasks Header ───────────────────────
            item {
                Spacer(modifier = Modifier.height(4.dp))
                SectionHeader(
                    title = "Today",
                    count = todayTasks.size
                )
            }

            // ── Task Cards ─────────────────────────────────
            if (todayTasks.isEmpty()) {
                item {
                    EmptyTodayCard()
                }
            } else {
                items(
                    items = todayTasks,
                    key = { it.id }
                ) { task ->
                    TaskCard(
                        task = task,
                        onTaskClick = onNavigateToTaskDetail,
                        onToggleComplete = { /* Phase 12 */ }
                    )
                }
            }

            // ── Overdue Section (if any) ───────────────────
            if (overdueCount > 0) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader(
                        title = "Overdue",
                        count = overdueCount
                    )
                }

                items(
                    items = MockData.overdueTasks,
                    key = { it.id }
                ) { task ->
                    TaskCard(
                        task = task,
                        onTaskClick = onNavigateToTaskDetail,
                        onToggleComplete = { /* Phase 12 */ }
                    )
                }
            }

            // Bottom spacer
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

// ─────────────────────────────────────────────────────────────
// Private Composables
// ─────────────────────────────────────────────────────────────

@Composable
private fun GreetingSection() {
    val hour = LocalTime.now().hour
    val greeting = when {
        hour < 12 -> "Good morning"
        hour < 17 -> "Good afternoon"
        else -> "Good evening"
    }

    Column {
        Text(
            text = "$greeting 👋",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Here's what's on your plate today.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun MetricCardsRow(
    todayCount: Int,
    upcomingCount: Int,
    overdueCount: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        MetricCard(
            count = todayCount,
            label = "Today",
            icon = Icons.Outlined.CalendarToday,
            accentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(1f)
        )
        MetricCard(
            count = upcomingCount,
            label = "Upcoming",
            icon = Icons.Outlined.Schedule,
            accentColor = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.weight(1f)
        )
        MetricCard(
            count = overdueCount,
            label = "Overdue",
            icon = Icons.Outlined.Warning,
            accentColor = MaterialTheme.colorScheme.error,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun AIInboxCard(
    pendingCount: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(AppDimens.CardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimens.CardContentPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.AutoAwesome,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "AI Inbox",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = if (pendingCount > 0) {
                        "$pendingCount items ready to analyze"
                    } else {
                        "Drop anything here. I'll organize it."
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f)
                )
            }
            Icon(
                imageVector = Icons.Outlined.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    count: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "$count tasks",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun EmptyTodayCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(AppDimens.CardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.CardElevation)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimens.PaddingLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "🎉",
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "All clear for today!",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "No tasks due today. Enjoy your free time or add something new.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AITaskOrganizerTheme {
        HomeScreen()
    }
}
