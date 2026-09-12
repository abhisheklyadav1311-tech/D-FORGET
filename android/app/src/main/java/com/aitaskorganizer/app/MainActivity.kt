package com.aitaskorganizer.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aitaskorganizer.app.ui.theme.AITaskOrganizerTheme
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.PriorityHigh
import com.aitaskorganizer.app.ui.theme.PriorityHighBg
import com.aitaskorganizer.app.ui.theme.PriorityLow
import com.aitaskorganizer.app.ui.theme.PriorityLowBg
import com.aitaskorganizer.app.ui.theme.PriorityMedium
import com.aitaskorganizer.app.ui.theme.PriorityMediumBg
import com.aitaskorganizer.app.ui.theme.PriorityUrgent
import com.aitaskorganizer.app.ui.theme.PriorityUrgentBg
import com.aitaskorganizer.app.ui.theme.StatusCompleted
import com.aitaskorganizer.app.ui.theme.StatusCompletedBg

/**
 * Single Activity that hosts the entire Compose UI.
 *
 * Phase 4: Navigation host will replace the theme preview content.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AITaskOrganizerTheme {
                Scaffold { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ThemePreview()
                    }
                }
            }
        }
    }
}

/**
 * Theme preview showing all design system elements.
 * This will be replaced by the navigation graph in Phase 4.
 */
@Composable
fun ThemePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(AppDimens.ScreenHorizontalPadding)
    ) {
        Spacer(modifier = Modifier.height(AppDimens.PaddingMedium))

        // ── App Title ──
        Text(
            text = "AI Task Organizer",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Design System Preview",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(AppDimens.PaddingLarge))

        // ── Color Swatches ──
        SectionTitle("Colors")
        ColorRow("Primary (Indigo)", MaterialTheme.colorScheme.primary)
        ColorRow("Secondary (Violet / AI)", MaterialTheme.colorScheme.secondary)
        ColorRow("Tertiary (Coral / Action)", MaterialTheme.colorScheme.tertiary)
        ColorRow("Error", MaterialTheme.colorScheme.error)

        Spacer(modifier = Modifier.height(AppDimens.PaddingMedium))

        // ── Priority Badges ──
        SectionTitle("Priority Badges")
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            PriorityBadge("Urgent", PriorityUrgent, PriorityUrgentBg)
            PriorityBadge("High", PriorityHigh, PriorityHighBg)
            PriorityBadge("Medium", PriorityMedium, PriorityMediumBg)
            PriorityBadge("Low", PriorityLow, PriorityLowBg)
        }
        Spacer(modifier = Modifier.height(8.dp))
        PriorityBadge("Completed", StatusCompleted, StatusCompletedBg)

        Spacer(modifier = Modifier.height(AppDimens.PaddingMedium))

        // ── Sample Card ──
        SectionTitle("Sample Task Card")
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(AppDimens.CardCornerRadius),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = AppDimens.CardElevation
            )
        ) {
            Column(modifier = Modifier.padding(AppDimens.CardContentPadding)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "DBMS Assignment",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    PriorityBadge("High", PriorityHigh, PriorityHighBg)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Complete and upload the DBMS assignment PDF to the portal.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(AppDimens.IconSizeSmall)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Due today, 5:00 PM",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(AppDimens.IconSizeSmall)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "8:00 PM",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(AppDimens.PaddingMedium))

        // ── AI Card ──
        SectionTitle("AI Element")
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(AppDimens.CardCornerRadius),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Row(
                modifier = Modifier.padding(AppDimens.CardContentPadding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.AutoAwesome,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(AppDimens.IconSizeLarge)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "AI Inbox",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = "Drop anything here. I'll organize it.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(AppDimens.PaddingMedium))

        // ── Typography Samples ──
        SectionTitle("Typography")
        Text("Headline Large", style = MaterialTheme.typography.headlineLarge)
        Text("Headline Medium", style = MaterialTheme.typography.headlineMedium)
        Text("Title Large", style = MaterialTheme.typography.titleLarge)
        Text("Title Medium", style = MaterialTheme.typography.titleMedium)
        Text("Body Large", style = MaterialTheme.typography.bodyLarge)
        Text("Body Medium", style = MaterialTheme.typography.bodyMedium)
        Text("Body Small", style = MaterialTheme.typography.bodySmall)
        Text("Label Large", style = MaterialTheme.typography.labelLarge)
        Text("Label Medium", style = MaterialTheme.typography.labelMedium)
        Text("Label Small", style = MaterialTheme.typography.labelSmall)

        Spacer(modifier = Modifier.height(AppDimens.PaddingXLarge))
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun ColorRow(label: String, color: androidx.compose.ui.graphics.Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
private fun PriorityBadge(
    label: String,
    textColor: androidx.compose.ui.graphics.Color,
    bgColor: androidx.compose.ui.graphics.Color
) {
    Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        fontWeight = FontWeight.SemiBold,
        color = textColor,
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ThemePreviewLight() {
    AITaskOrganizerTheme {
        ThemePreview()
    }
}
