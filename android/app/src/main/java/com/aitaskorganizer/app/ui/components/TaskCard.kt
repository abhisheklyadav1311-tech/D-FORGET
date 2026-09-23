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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.model.TaskUiModel
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.SuccessGreen
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Composable
fun TaskCard(
    task: TaskUiModel,
    onTaskClick: (Long) -> Unit,
    onToggleComplete: (Long) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val isCompleted = task.status == TaskStatus.COMPLETED

    BrutalBox(
        backgroundColor = Color.White,
        cornerRadius = AppDimens.CornerRadiusSmall,
        modifier = modifier.fillMaxWidth(),
        onClick = { onTaskClick(task.id) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Checkbox(
                checked = isCompleted,
                onCheckedChange = { onToggleComplete(task.id) },
                colors = CheckboxDefaults.colors(
                    checkedColor = SuccessGreen,
                    uncheckedColor = Color(0xFF1A1A1A),
                    checkmarkColor = Color.White
                ),
                modifier = Modifier.size(40.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp, end = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.title.uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A1A1A),
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

                Spacer(modifier = Modifier.height(4.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    if (task.subject.isNotBlank()) {
                        Text(
                            text = task.subject.uppercase(),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                    if (task.category.isNotBlank()) {
                        Text(
                            text = "/ ${task.category.uppercase()}",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (task.deadline != null) {
                        val deadlineInfo = formatDeadline(task.deadline)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Schedule,
                                contentDescription = null,
                                tint = deadlineInfo.color,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = deadlineInfo.text.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = deadlineInfo.color
                            )
                        }
                    }

                    if (task.hasReminder) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Notifications,
                                contentDescription = "Has reminder",
                                tint = Color(0xFF1A1A1A),
                                modifier = Modifier.size(14.dp)
                            )
                            if (task.reminderTime != null) {
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = task.reminderTime.format(
                                        DateTimeFormatter.ofPattern("h:mm a")
                                    ).uppercase(),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1A1A1A)
                                )
                            }
                        }
                    }

                    if (task.isAiGenerated) {
                        Icon(
                            imageVector = Icons.OutAwesome,
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

private val Icons.OutAwesome get() = Icons.Outlined.AutoAwesome

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

    val overdueColor = MaterialTheme.colorScheme.secondary
    val urgentColor = MaterialTheme.colorScheme.secondary
    val normalColor = Color(0xFF1A1A1A)

    return when {
        isOverdue -> DeadlineInfo(
            text = if (daysUntil == -1L) "OVERDUE · YESTERDAY" else "OVERDUE · ${-daysUntil}D AGO",
            color = overdueColor
        )
        isToday -> DeadlineInfo(
            text = "TODAY, ${deadline.format(timeFormatter)}",
            color = urgentColor
        )
        isTomorrow -> DeadlineInfo(
            text = "TOMORROW, ${deadline.format(timeFormatter)}",
            color = urgentColor
        )
        daysUntil <= 7 -> DeadlineInfo(
            text = "IN ${daysUntil}D · ${deadline.format(DateTimeFormatter.ofPattern("EEE"))}",
            color = normalColor
        )
        else -> DeadlineInfo(
            text = deadline.format(DateTimeFormatter.ofPattern("MMM d")),
            color = normalColor
        )
    }
}

private data class DeadlineInfo(val text: String, val color: Color)
