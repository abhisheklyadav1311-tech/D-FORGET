package com.aitaskorganizer.app.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.data.model.TaskUiModel
import com.aitaskorganizer.app.ui.components.BrutalBox
import com.aitaskorganizer.app.ui.components.MetricCard
import com.aitaskorganizer.app.ui.components.TaskCard
import com.aitaskorganizer.app.ui.home.viewmodel.HomeViewModel
import com.aitaskorganizer.app.ui.theme.AITaskOrganizerTheme
import com.aitaskorganizer.app.ui.theme.AppDimens
import java.time.LocalTime

@Composable
fun HomeScreen(
    viewModel: HomeViewModel? = null,
    onNavigateToTaskDetail: (Long) -> Unit = {},
    onNavigateToAddTask: () -> Unit = {},
    onNavigateToAIInbox: () -> Unit = {}
) {
    val todayTasks by (viewModel?.todayTasks ?: kotlinx.coroutines.flow.MutableStateFlow(emptyList<TaskUiModel>())).collectAsState()
    val overdueTasks by (viewModel?.overdueTasks ?: kotlinx.coroutines.flow.MutableStateFlow(emptyList<TaskUiModel>())).collectAsState()
    val upcomingCount by (viewModel?.upcomingCount ?: kotlinx.coroutines.flow.MutableStateFlow(0)).collectAsState()
    val overdueCount by (viewModel?.overdueCount ?: kotlinx.coroutines.flow.MutableStateFlow(0)).collectAsState()
    val todayCount by (viewModel?.todayCount ?: kotlinx.coroutines.flow.MutableStateFlow(0)).collectAsState()
    val aiInboxCount by (viewModel?.aiInboxCount ?: kotlinx.coroutines.flow.MutableStateFlow(0)).collectAsState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            BrutalBox(
                backgroundColor = MaterialTheme.colorScheme.primary,
                cornerRadius = AppDimens.CornerRadiusMedium,
                onClick = onNavigateToAddTask
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add new task",
                        tint = Color(0xFF1A1A1A)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "NEW TASK",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A1A1A)
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                start = AppDimens.ScreenHorizontalPadding,
                end = AppDimens.ScreenHorizontalPadding,
                top = AppDimens.ScreenTopPadding,
                bottom = 100.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                GreetingSection()
            }

            item {
                MetricCardsRow(
                    todayCount = todayCount,
                    upcomingCount = upcomingCount,
                    overdueCount = overdueCount
                )
            }

            item {
                AIInboxCard(
                    pendingCount = aiInboxCount,
                    onClick = onNavigateToAIInbox
                )
            }

            item {
                Spacer(modifier = Modifier.height(4.dp))
                SectionHeader(
                    title = "TODAY",
                    count = todayCount
                )
            }

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
                        onToggleComplete = { id -> viewModel?.toggleTaskCompletion(id) }
                    )
                }
            }

            if (overdueCount > 0) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader(
                        title = "OVERDUE",
                        count = overdueCount
                    )
                }

                items(
                    items = overdueTasks,
                    key = { it.id }
                ) { task ->
                    TaskCard(
                        task = task,
                        onTaskClick = onNavigateToTaskDetail,
                        onToggleComplete = { id -> viewModel?.toggleTaskCompletion(id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun GreetingSection() {
    val hour = LocalTime.now().hour
    val greeting = when {
        hour < 12 -> "GOOD MORNING"
        hour < 17 -> "GOOD AFTERNOON"
        else -> "GOOD EVENING"
    }

    Column {
        Text(
            text = "$greeting 👋",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF1A1A1A)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "HERE'S WHAT'S ON YOUR PLATE TODAY.",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A1A)
        )
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
            accentColor = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun AIInboxCard(
    pendingCount: Int,
    onClick: () -> Unit
) {
    BrutalBox(
        backgroundColor = MaterialTheme.colorScheme.secondary,
        cornerRadius = AppDimens.CornerRadiusSmall,
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.AutoAwesome,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "AI INBOX",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Text(
                    text = if (pendingCount > 0) {
                        "$pendingCount ITEMS READY TO ANALYZE"
                    } else {
                        "DROP ANYTHING HERE. I'LL ORGANIZE IT."
                    },
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
            Icon(
                imageVector = Icons.Outlined.ChevronRight,
                contentDescription = null,
                tint = Color.White,
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
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF1A1A1A)
        )
        Text(
            text = "$count TASKS",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF1A1A1A)
        )
    }
}

@Composable
private fun EmptyTodayCard() {
    BrutalBox(
        backgroundColor = Color.White,
        cornerRadius = AppDimens.CornerRadiusSmall,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "🎉",
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "ALL CLEAR FOR TODAY!",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1A1A1A)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "NO TASKS DUE TODAY. ENJOY YOUR FREE TIME OR ADD SOMETHING NEW.",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
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
