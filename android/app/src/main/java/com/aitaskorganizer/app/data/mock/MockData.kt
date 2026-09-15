package com.aitaskorganizer.app.data.mock

import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.model.TaskUiModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Mock data for UI development.
 *
 * Uses realistic college/academic examples from the PRD.
 * Will be replaced by Room database queries in Phase 12.
 */
object MockData {

    private val today = LocalDate.now()

    val tasks = listOf(
        TaskUiModel(
            id = 1,
            title = "DBMS Assignment",
            description = "Complete and upload the DBMS assignment PDF to the college portal before the deadline.",
            deadline = LocalDateTime.of(today, LocalTime.of(17, 0)),
            priority = Priority.HIGH,
            category = "Assignment",
            subject = "DBMS",
            status = TaskStatus.PENDING,
            isAiGenerated = true,
            hasReminder = true,
            reminderTime = LocalDateTime.of(today, LocalTime.of(14, 0)),
            sourceId = 1
        ),
        TaskUiModel(
            id = 2,
            title = "DSA Presentation",
            description = "Prepare slides for the Data Structures presentation on sorting algorithms.",
            deadline = LocalDateTime.of(today.plusDays(1), LocalTime.of(10, 0)),
            priority = Priority.MEDIUM,
            category = "Presentation",
            subject = "DSA",
            status = TaskStatus.PENDING,
            isAiGenerated = true,
            hasReminder = true,
            reminderTime = LocalDateTime.of(today, LocalTime.of(20, 0)),
            sourceId = 2
        ),
        TaskUiModel(
            id = 3,
            title = "OS Lab Submission",
            description = "Submit the Operating Systems lab report including process scheduling implementation.",
            deadline = LocalDateTime.of(today.minusDays(1), LocalTime.of(23, 59)),
            priority = Priority.URGENT,
            category = "Lab",
            subject = "Operating Systems",
            status = TaskStatus.PENDING,
            isAiGenerated = true,
            hasReminder = false,
            sourceId = 3
        ),
        TaskUiModel(
            id = 4,
            title = "Review CN Notes",
            description = "Review Computer Networks notes for the upcoming mid-term examination.",
            deadline = LocalDateTime.of(today.plusDays(5), LocalTime.of(9, 0)),
            priority = Priority.LOW,
            category = "Study",
            subject = "Computer Networks",
            status = TaskStatus.PENDING,
            isAiGenerated = false,
            hasReminder = false
        ),
        TaskUiModel(
            id = 5,
            title = "Math Tutorial Sheet",
            description = "Solve tutorial sheet #7 on differential equations.",
            deadline = LocalDateTime.of(today.plusDays(3), LocalTime.of(11, 30)),
            priority = Priority.MEDIUM,
            category = "Assignment",
            subject = "Mathematics",
            status = TaskStatus.PENDING,
            isAiGenerated = false,
            hasReminder = true,
            reminderTime = LocalDateTime.of(today.plusDays(2), LocalTime.of(18, 0))
        ),
        TaskUiModel(
            id = 6,
            title = "Java Project Submission",
            description = "Final submission of the Java mini project with documentation.",
            deadline = LocalDateTime.of(today.minusDays(2), LocalTime.of(17, 0)),
            priority = Priority.HIGH,
            category = "Project",
            subject = "Java",
            status = TaskStatus.COMPLETED,
            isAiGenerated = true,
            hasReminder = false,
            sourceId = 4
        )
    )

    /** Tasks due today that are still pending. */
    val todayTasks: List<TaskUiModel>
        get() = tasks.filter {
            it.status == TaskStatus.PENDING &&
                it.deadline?.toLocalDate() == today
        }

    /** Tasks due after today that are still pending. */
    val upcomingTasks: List<TaskUiModel>
        get() = tasks.filter {
            it.status == TaskStatus.PENDING &&
                it.deadline != null &&
                it.deadline.toLocalDate().isAfter(today)
        }

    /** Tasks past their deadline that are still pending. */
    val overdueTasks: List<TaskUiModel>
        get() = tasks.filter {
            it.status == TaskStatus.PENDING &&
                it.deadline != null &&
                it.deadline.toLocalDate().isBefore(today)
        }

    /** All pending tasks. */
    val pendingTasks: List<TaskUiModel>
        get() = tasks.filter { it.status == TaskStatus.PENDING }

    /** Completed tasks. */
    val completedTasks: List<TaskUiModel>
        get() = tasks.filter { it.status == TaskStatus.COMPLETED }

    /** Number of pending AI analysis items (mock). */
    val aiInboxCount = 2
}
