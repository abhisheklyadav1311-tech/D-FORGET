package com.aitaskorganizer.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.model.TaskUiModel
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.StatusCompleted
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

/**
 * Task card composable used across Home, Tasks, and Completed screens.
 *
 * Displays:
 * - Completion checkbox
 * - Title (with strikethrough if completed)
 * - Subject + Category badges
 * - Deadline with contextual formatting
 * - Priority badge
 * - Reminder indicator
 * - AI-generated indicator
 *
 * @param task The task to display
 * @param onTaskClick Navigate to task detail
 * @param onToggleComplete Toggle task completion
 */
@Composable
fun TaskCard(
    task: TaskUiModel,
    onTaskClick: (Long) -> Unit,
    onToggleComplete: (Long) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val isCompleted = task.status == TaskStatus.COMPLETED

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onTaskClick(task.id) },
        shape = RoundedCornerShape(AppDimens.CardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppDimens.CardElevation
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = AppDimens.CardContentPadding,
                    top = 12.dp,
                    bottom = 12.dp
                ),
            verticalAlignment = Alignment.Top
        ) {
            // Checkbox
            Checkbox(
                checked = isCompleted,
                onCheckedChange = { onToggleComplete(task.id) },
                colors = CheckboxDefaults.colors(
                    checkedColor = StatusCompleted,
                    uncheckedColor = MaterialTheme.colorScheme.outline,
                    checkmarkColor = MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.size(AppDimens.TouchTargetMin)
            )

            // Content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 10.dp)
            ) {
                // Title + Priority
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.titleLarge,
                        color = if (isCompleted) {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        } else {
                            MaterialTheme.colorScheme.onSurface
                        },
                        textDecoration = if (isCompleted) TextDecoration.LineThrough else null,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    if (!isCompleted) {
                        PriorityBadge(priority = task.priority)
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Subject + Category
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    if (task.subject.isNotBlank()) {
                        Text(
                            text = task.subject,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    if (task.category.isNotBlank()) {
                        Text(
                            text = "· ${task.category}",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Deadline + Reminder + AI indicator
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Deadline
                    if (task.deadline != null) {
                        val deadlineInfo = formatDeadline(task.deadline)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Schedule,
                                contentDescription = null,
                                tint = deadlineInfo.color,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = deadlineInfo.text,
                                style = MaterialTheme.typography.labelSmall,
                                color = deadlineInfo.color
                            )
                        }
                    }

                    // Reminder indicator
                    if (task.hasReminder) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Notifications,
                                contentDescription = "Has reminder",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(14.dp)
                            )
                            if (task.reminderTime != null) {
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = task.reminderTime.format(
                                        DateTimeFormatter.ofPattern("h:mm a")
                                    ),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    // AI indicator
                    if (task.isAiGenerated) {
                        Icon(
                            imageVector = Icons.Outlined.AutoAwesome,
                            contentDescription = "AI generated",
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Formats a deadline into a human-readable contextual string.
 */
@Composable
private fun formatDeadline(deadline: LocalDateTime): DeadlineInfo {
    val now = LocalDateTime.now()
    val today = LocalDate.now()
    val deadlineDate = deadline.toLocalDate()
    val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")

    val isOverdue = deadline.isBefore(now)
    val isToday = deadlineDate == today
    val isTomorrow = deadlineDate == today.plusDays(1)
    val daysUntil = ChronoUnit.DAYS.between(today, deadlineDate)

    val overdueColor = MaterialTheme.colorScheme.error
    val urgentColor = MaterialTheme.colorScheme.tertiary
    val normalColor = MaterialTheme.colorScheme.onSurfaceVariant

    return when {
        isOverdue -> DeadlineInfo(
            text = if (daysUntil == -1L) "Overdue · Yesterday"
            else "Overdue · ${-daysUntil}d ago",
            color = overdueColor
        )
        isToday -> DeadlineInfo(
            text = "Today, ${deadline.format(timeFormatter)}",
            color = urgentColor
        )
        isTomorrow -> DeadlineInfo(
            text = "Tomorrow, ${deadline.format(timeFormatter)}",
            color = urgentColor
        )
        daysUntil <= 7 -> DeadlineInfo(
            text = "In ${daysUntil}d · ${deadline.format(DateTimeFormatter.ofPattern("EEE"))}",
            color = normalColor
        )
        else -> DeadlineInfo(
            text = deadline.format(DateTimeFormatter.ofPattern("MMM d")),
            color = normalColor
        )
    }
}

private data class DeadlineInfo(val text: String, val color: androidx.compose.ui.graphics.Color)
