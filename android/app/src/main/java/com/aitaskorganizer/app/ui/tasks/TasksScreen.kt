package com.aitaskorganizer.app.ui.tasks

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.data.mock.MockData
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.model.TaskUiModel
import com.aitaskorganizer.app.ui.components.TaskCard
import com.aitaskorganizer.app.ui.theme.AITaskOrganizerTheme
import com.aitaskorganizer.app.ui.theme.AppDimens
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Tasks screen with tab filtering and search.
 *
 * Sections:
 * 1. Screen title
 * 2. Search bar + filter button
 * 3. Segmented tabs (All / Today / Upcoming / Overdue)
 * 4. Filtered task list with date grouping
 * 5. FAB for new task
 */
@Composable
fun TasksScreen(
    onNavigateToTaskDetail: (Long) -> Unit = {},
    onNavigateToAddTask: () -> Unit = {}
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val tabs = TaskTab.entries

    // Filter tasks based on selected tab and search query
    val filteredTasks = remember(selectedTabIndex, searchQuery) {
        val pendingTasks = MockData.pendingTasks
        val tabFiltered = when (tabs[selectedTabIndex]) {
            TaskTab.ALL -> pendingTasks
            TaskTab.TODAY -> MockData.todayTasks
            TaskTab.UPCOMING -> MockData.upcomingTasks
            TaskTab.OVERDUE -> MockData.overdueTasks
        }

        if (searchQuery.isBlank()) {
            tabFiltered
        } else {
            tabFiltered.filter { task ->
                task.title.contains(searchQuery, ignoreCase = true) ||
                    task.description.contains(searchQuery, ignoreCase = true) ||
                    task.subject.contains(searchQuery, ignoreCase = true) ||
                    task.category.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    // Group tasks by date for display
    val groupedTasks = remember(filteredTasks) {
        groupTasksByDate(filteredTasks)
    }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // ── Header ─────────────────────────────────────
            Column(
                modifier = Modifier.padding(
                    start = AppDimens.ScreenHorizontalPadding,
                    end = AppDimens.ScreenHorizontalPadding,
                    top = AppDimens.ScreenTopPadding
                )
            ) {
                Text(
                    text = "Tasks",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(12.dp))

                // ── Search Bar ─────────────────────────────
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ── Tab Row ────────────────────────────────────
            TaskTabRow(
                tabs = tabs,
                selectedIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it },
                taskCounts = mapOf(
                    TaskTab.ALL to MockData.pendingTasks.size,
                    TaskTab.TODAY to MockData.todayTasks.size,
                    TaskTab.UPCOMING to MockData.upcomingTasks.size,
                    TaskTab.OVERDUE to MockData.overdueTasks.size
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ── Task List ──────────────────────────────────
            AnimatedContent(
                targetState = selectedTabIndex,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                label = "tab_content"
            ) { _ ->
                if (filteredTasks.isEmpty()) {
                    EmptyTasksState(tab = tabs[selectedTabIndex], hasSearch = searchQuery.isNotBlank())
                } else {
                    TaskList(
                        groupedTasks = groupedTasks,
                        onTaskClick = onNavigateToTaskDetail,
                        onToggleComplete = { /* Phase 12 */ }
                    )
                }
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────
// Private Composables
// ─────────────────────────────────────────────────────────────

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = {
            Text(
                text = "Search tasks...",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
        },
        trailingIcon = {
            IconButton(onClick = { /* Phase 10: Filter dialog */ }) {
                Icon(
                    imageVector = Icons.Outlined.FilterList,
                    contentDescription = "Filters",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(AppDimens.CornerRadiusMedium),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
            focusedBorderColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun TaskTabRow(
    tabs: List<TaskTab>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    taskCounts: Map<TaskTab, Int>
) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primary,
        edgePadding = AppDimens.ScreenHorizontalPadding,
        divider = {},
        indicator = {}
    ) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = selectedIndex == index
            val count = taskCounts[tab] ?: 0

            Tab(
                selected = isSelected,
                onClick = { onTabSelected(index) },
                modifier = Modifier.padding(horizontal = 2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(AppDimens.CornerRadiusFull))
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceContainerHigh
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = tab.label,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) {
                                MaterialTheme.colorScheme.onPrimary
                            } else {
                                MaterialTheme.colorScheme.onSurfaceVariant
                            }
                        )
                        if (count > 0) {
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = count.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) {
                                    MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TaskList(
    groupedTasks: Map<String, List<TaskUiModel>>,
    onTaskClick: (Long) -> Unit,
    onToggleComplete: (Long) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = AppDimens.ScreenHorizontalPadding,
            end = AppDimens.ScreenHorizontalPadding,
            top = 4.dp,
            bottom = 80.dp
        ),
        verticalArrangement = Arrangement.spacedBy(AppDimens.CardSpacing)
    ) {
        groupedTasks.forEach { (dateLabel, tasks) ->
            // Date group header
            item(key = "header_$dateLabel") {
                Text(
                    text = dateLabel,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
            }

            // Tasks in this group
            items(
                items = tasks,
                key = { it.id }
            ) { task ->
                TaskCard(
                    task = task,
                    onTaskClick = onTaskClick,
                    onToggleComplete = onToggleComplete
                )
            }
        }
    }
}

@Composable
private fun EmptyTasksState(tab: TaskTab, hasSearch: Boolean) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val (emoji, title, subtitle) = when {
                hasSearch -> Triple(
                    "🔍",
                    "No results found",
                    "Try a different search term."
                )
                tab == TaskTab.TODAY -> Triple(
                    "🎉",
                    "All clear for today!",
                    "No tasks due today."
                )
                tab == TaskTab.OVERDUE -> Triple(
                    "✅",
                    "Nothing overdue",
                    "You're all caught up!"
                )
                tab == TaskTab.UPCOMING -> Triple(
                    "📅",
                    "No upcoming tasks",
                    "Add a task to get started."
                )
                else -> Triple(
                    "📝",
                    "No tasks yet",
                    "Tap + to create your first task."
                )
            }

            Text(text = emoji, style = MaterialTheme.typography.displaySmall)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────
// Helpers
// ─────────────────────────────────────────────────────────────

/**
 * Groups tasks by date label for section headers.
 */
private fun groupTasksByDate(tasks: List<TaskUiModel>): Map<String, List<TaskUiModel>> {
    val today = LocalDate.now()
    val tomorrow = today.plusDays(1)
    val dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMM d")

    return tasks
        .sortedBy { it.deadline ?: LocalDate.MAX.atStartOfDay() }
        .groupBy { task ->
            val date = task.deadline?.toLocalDate()
            when {
                date == null -> "No deadline"
                date.isBefore(today) -> "Overdue"
                date == today -> "Today"
                date == tomorrow -> "Tomorrow"
                date.isBefore(today.plusWeeks(1)) -> "This week"
                else -> date.format(dateFormatter)
            }
        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TasksScreenPreview() {
    AITaskOrganizerTheme {
        TasksScreen()
    }
}
