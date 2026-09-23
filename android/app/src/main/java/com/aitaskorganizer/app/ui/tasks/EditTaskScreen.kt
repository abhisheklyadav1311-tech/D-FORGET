package com.aitaskorganizer.app.ui.tasks

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.ui.components.BrutalBox
import com.aitaskorganizer.app.ui.tasks.viewmodel.EditTaskUiState
import com.aitaskorganizer.app.ui.tasks.viewmodel.EditTaskViewModel
import com.aitaskorganizer.app.ui.theme.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTaskScreen(
    viewModel: EditTaskViewModel,
    onBack: () -> Unit,
    onSaved: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(uiState) {
        if (uiState is EditTaskUiState.Saved) {
            onSaved()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (viewModel.title.isEmpty()) "NEW TASK" else "EDIT TASK",
                        fontWeight = FontWeight.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.saveTask(context) }) {
                        Icon(Icons.Default.Check, contentDescription = "Save", tint = SuccessGreen)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BauhausWhite,
                    titleContentColor = BauhausBlack
                )
            )
        },
        containerColor = BauhausWhite
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (val state = uiState) {
                is EditTaskUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = BauhausBlack)
                }
                is EditTaskUiState.Error -> {
                    Text(
                        text = state.message,
                        modifier = Modifier.align(Alignment.Center),
                        color = BauhausRed
                    )
                }
                else -> {
                    EditTaskContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun EditTaskContent(viewModel: EditTaskViewModel) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Title Input
        BrutalBox(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.title,
                onValueChange = { viewModel.title = it },
                label = { Text("Title", fontWeight = FontWeight.Bold) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = BauhausYellow,
                    unfocusedIndicatorColor = BauhausBlack
                ),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }

        // Subject Input
        BrutalBox(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.subject,
                onValueChange = { viewModel.subject = it },
                label = { Text("Subject", fontWeight = FontWeight.Bold) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = BauhausYellow,
                    unfocusedIndicatorColor = BauhausBlack
                )
            )
        }

        // Priority Selection
        Text("PRIORITY", fontWeight = FontWeight.Black, fontSize = 12.sp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Priority.entries.forEach { priority ->
                val isSelected = viewModel.priority == priority
                BrutalBox(
                    backgroundColor = if (isSelected) getPriorityColor(priority) else BauhausWhite,
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.priority = priority },
                    cornerRadius = 4.dp
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = priority.name,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = if (isSelected) BauhausBlack else BauhausBlack.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }

        // Category Input
        BrutalBox(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.category,
                onValueChange = { viewModel.category = it },
                label = { Text("Category", fontWeight = FontWeight.Bold) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = BauhausYellow,
                    unfocusedIndicatorColor = BauhausBlack
                )
            )
        }

        // ── Deadline Picker ──────────────────────────────
        Text("DEADLINE", fontWeight = FontWeight.Black, fontSize = 12.sp)
        BrutalBox(
            backgroundColor = Color.White,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val now = LocalDate.now()
                val initialDate = viewModel.deadline?.toLocalDate() ?: now
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        val selectedDate = LocalDate.of(year, month + 1, day)
                        // After date, show time picker
                        val initialTime = viewModel.deadline?.toLocalTime() ?: LocalTime.of(17, 0)
                        TimePickerDialog(
                            context,
                            { _, hour, minute ->
                                viewModel.deadline = LocalDateTime.of(selectedDate, LocalTime.of(hour, minute))
                            },
                            initialTime.hour,
                            initialTime.minute,
                            false
                        ).show()
                    },
                    initialDate.year,
                    initialDate.monthValue - 1,
                    initialDate.dayOfMonth
                ).show()
            },
            cornerRadius = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.CalendarToday,
                    contentDescription = null,
                    tint = BauhausBlack,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    text = viewModel.deadline?.format(
                        DateTimeFormatter.ofPattern("EEE, MMM d yyyy · h:mm a")
                    ) ?: "Tap to set deadline",
                    fontWeight = FontWeight.SemiBold,
                    color = if (viewModel.deadline != null) BauhausBlack else BauhausBlack.copy(alpha = 0.4f)
                )
            }
        }

        // Clear deadline button
        if (viewModel.deadline != null) {
            TextButton(onClick = { viewModel.deadline = null }) {
                Text("Clear deadline", color = BauhausRed, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }

        // Description Input
        BrutalBox(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.description,
                onValueChange = { viewModel.description = it },
                label = { Text("Description", fontWeight = FontWeight.Bold) },
                modifier = Modifier.fillMaxWidth().heightIn(min = 120.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = BauhausYellow,
                    unfocusedIndicatorColor = BauhausBlack
                ),
                singleLine = false
            )
        }

        // ── Reminder Toggle + Time Picker ────────────────
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("ENABLE REMINDER", fontWeight = FontWeight.Black, fontSize = 14.sp)
            Switch(
                checked = viewModel.hasReminder,
                onCheckedChange = { viewModel.hasReminder = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = SuccessGreen,
                    checkedTrackColor = SuccessGreen.copy(alpha = 0.5f),
                    uncheckedThumbColor = BauhausBlack,
                    uncheckedTrackColor = BauhausWhite
                )
            )
        }

        // Reminder time picker (visible when reminder is enabled)
        if (viewModel.hasReminder) {
            BrutalBox(
                backgroundColor = Color.White,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val now = LocalDate.now()
                    val initialDate = viewModel.reminderTime?.toLocalDate() ?: viewModel.deadline?.toLocalDate() ?: now
                    DatePickerDialog(
                        context,
                        { _, year, month, day ->
                            val selectedDate = LocalDate.of(year, month + 1, day)
                            val initialTime = viewModel.reminderTime?.toLocalTime() ?: LocalTime.of(9, 0)
                            TimePickerDialog(
                                context,
                                { _, hour, minute ->
                                    viewModel.reminderTime = LocalDateTime.of(selectedDate, LocalTime.of(hour, minute))
                                },
                                initialTime.hour,
                                initialTime.minute,
                                false
                            ).show()
                        },
                        initialDate.year,
                        initialDate.monthValue - 1,
                        initialDate.dayOfMonth
                    ).show()
                },
                cornerRadius = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Outlined.Notifications,
                        contentDescription = null,
                        tint = BauhausBlack,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = viewModel.reminderTime?.format(
                            DateTimeFormatter.ofPattern("EEE, MMM d · h:mm a")
                        ) ?: "Tap to set reminder time",
                        fontWeight = FontWeight.SemiBold,
                        color = if (viewModel.reminderTime != null) BauhausBlack else BauhausBlack.copy(alpha = 0.4f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

private fun getPriorityColor(priority: Priority): Color {
    return when (priority) {
        Priority.LOW -> PriorityLow
        Priority.MEDIUM -> PriorityMedium
        Priority.HIGH -> PriorityHigh
        Priority.URGENT -> PriorityUrgent
    }
}
