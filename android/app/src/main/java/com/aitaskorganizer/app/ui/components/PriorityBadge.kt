package com.aitaskorganizer.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.PriorityHigh
import com.aitaskorganizer.app.ui.theme.PriorityLow
import com.aitaskorganizer.app.ui.theme.PriorityMedium
import com.aitaskorganizer.app.ui.theme.PriorityUrgent

@Composable
fun PriorityBadge(
    priority: Priority,
    modifier: Modifier = Modifier
) {
    val (bgColor, label) = when (priority) {
        Priority.URGENT -> Pair(PriorityUrgent, "URGENT")
        Priority.HIGH -> Pair(PriorityHigh, "HIGH")
        Priority.MEDIUM -> Pair(PriorityMedium, "MEDIUM")
        Priority.LOW -> Pair(PriorityLow, "LOW")
    }

    Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        fontWeight = FontWeight.ExtraBold,
        color = Color(0xFF1A1A1A),
        modifier = modifier
            .background(bgColor, shape = RoundedCornerShape(AppDimens.CornerRadiusSmall))
            .border(width = 1.5.dp, color = Color(0xFF1A1A1A), shape = RoundedCornerShape(AppDimens.CornerRadiusSmall))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}

fun priorityColor(priority: Priority): Color = when (priority) {
    Priority.URGENT -> PriorityUrgent
    Priority.HIGH -> PriorityHigh
    Priority.MEDIUM -> PriorityMedium
    Priority.LOW -> PriorityLow
}
