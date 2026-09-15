package com.aitaskorganizer.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.ui.theme.PriorityHigh
import com.aitaskorganizer.app.ui.theme.PriorityHighBg
import com.aitaskorganizer.app.ui.theme.PriorityLow
import com.aitaskorganizer.app.ui.theme.PriorityLowBg
import com.aitaskorganizer.app.ui.theme.PriorityMedium
import com.aitaskorganizer.app.ui.theme.PriorityMediumBg
import com.aitaskorganizer.app.ui.theme.PriorityUrgent
import com.aitaskorganizer.app.ui.theme.PriorityUrgentBg

/**
 * Compact priority badge displayed on task cards.
 *
 * Colors per Section 14:
 * - Urgent → red
 * - High → coral/orange
 * - Medium → amber
 * - Low → muted blue-gray
 */
@Composable
fun PriorityBadge(
    priority: Priority,
    modifier: Modifier = Modifier
) {
    val (textColor, bgColor, label) = when (priority) {
        Priority.URGENT -> Triple(PriorityUrgent, PriorityUrgentBg, "Urgent")
        Priority.HIGH -> Triple(PriorityHigh, PriorityHighBg, "High")
        Priority.MEDIUM -> Triple(PriorityMedium, PriorityMediumBg, "Medium")
        Priority.LOW -> Triple(PriorityLow, PriorityLowBg, "Low")
    }

    Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        fontWeight = FontWeight.SemiBold,
        color = textColor,
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    )
}

/**
 * Returns the priority text color for inline text usage.
 */
fun priorityColor(priority: Priority): Color = when (priority) {
    Priority.URGENT -> PriorityUrgent
    Priority.HIGH -> PriorityHigh
    Priority.MEDIUM -> PriorityMedium
    Priority.LOW -> PriorityLow
}
