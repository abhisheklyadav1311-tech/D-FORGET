package com.aitaskorganizer.app.ui.theme

import androidx.compose.ui.unit.dp

/**
 * Spacing and dimension constants for consistent layout.
 *
 * Usage: Use these instead of raw dp values for spacing.
 * Example: Modifier.padding(horizontal = AppDimens.PaddingMedium)
 */
object AppDimens {

    // ── Padding / Spacing ──────────────────────────────────
    val PaddingXSmall = 4.dp
    val PaddingSmall = 8.dp
    val PaddingMedium = 16.dp
    val PaddingLarge = 24.dp
    val PaddingXLarge = 32.dp

    // ── Screen-level margins ───────────────────────────────
    val ScreenHorizontalPadding = 20.dp
    val ScreenTopPadding = 16.dp

    // ── Card dimensions ────────────────────────────────────
    val CardCornerRadius = 16.dp
    val CardElevation = 1.dp
    val CardContentPadding = 16.dp
    val CardSpacing = 12.dp

    // ── Component sizing ───────────────────────────────────
    val IconSizeSmall = 16.dp
    val IconSizeMedium = 20.dp
    val IconSizeLarge = 24.dp
    val IconSizeXLarge = 32.dp

    val TouchTargetMin = 48.dp
    val ButtonHeight = 48.dp
    val BottomNavHeight = 80.dp
    val TopBarHeight = 64.dp

    val CheckboxSize = 24.dp
    val BadgeHeight = 24.dp
    val ChipHeight = 32.dp

    // ── Metric card ────────────────────────────────────────
    val MetricCardMinWidth = 100.dp

    // ── FAB ────────────────────────────────────────────────
    val FabSize = 56.dp

    // ── Divider ────────────────────────────────────────────
    val DividerThickness = 0.5.dp

    // ── Corner radii ───────────────────────────────────────
    val CornerRadiusSmall = 8.dp
    val CornerRadiusMedium = 12.dp
    val CornerRadiusLarge = 16.dp
    val CornerRadiusFull = 100.dp
}
