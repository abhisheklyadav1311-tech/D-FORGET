package com.aitaskorganizer.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Light color scheme for AI Task Organizer.
 *
 * Design intent:
 * - Primary (Indigo): Main app identity, navigation, primary buttons
 * - Secondary (Violet): AI-related elements, analysis, proposals
 * - Tertiary (Coral): Important actions, reminders, deadlines
 * - Background: Very light cool gray for calm, premium feel
 * - Surface: White cards with subtle elevation
 */
private val LightColorScheme = lightColorScheme(
    // Primary — Deep Indigo
    primary = Indigo,
    onPrimary = OnIndigo,
    primaryContainer = IndigoLight,
    onPrimaryContainer = OnIndigoLight,

    // Secondary — Soft Violet (AI)
    secondary = Violet,
    onSecondary = OnViolet,
    secondaryContainer = VioletContainer,
    onSecondaryContainer = OnVioletLight,

    // Tertiary — Warm Coral (Actions/Reminders)
    tertiary = Coral,
    onTertiary = OnCoral,
    tertiaryContainer = CoralContainer,
    onTertiaryContainer = OnCoralLight,

    // Error
    error = ErrorRed,
    onError = OnError,
    errorContainer = ErrorRedLight,
    onErrorContainer = OnErrorLight,

    // Background & Surface
    background = BackgroundLight,
    onBackground = TextPrimary,
    surface = SurfaceLight,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = TextSecondary,
    surfaceContainerLowest = SurfaceLight,
    surfaceContainerLow = SurfaceContainerLight,
    surfaceContainer = SurfaceContainerLight,
    surfaceContainerHigh = SurfaceContainerHighLight,
    surfaceDim = SurfaceDim,

    // Outline
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight,

    // Inverse (for snackbars, toasts)
    inverseSurface = TextPrimary,
    inverseOnSurface = SurfaceLight,
    inversePrimary = IndigoLight,
)

/**
 * AI Task Organizer Material 3 theme.
 *
 * Wraps the entire app with consistent colors, typography, and shapes.
 * Currently light-only — dark theme can be added later.
 *
 * Usage:
 * ```
 * AITaskOrganizerTheme {
 *     // Your composables here
 * }
 * ```
 */
@Composable
fun AITaskOrganizerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Currently light-only. Dark theme will use a separate darkColorScheme.
    val colorScheme = LightColorScheme

    // Update system bars to match theme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // enableEdgeToEdge() in MainActivity handles transparent bars.
            // Here we just ensure light status/nav bar icons for our light theme.
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = true
                isAppearanceLightNavigationBars = true
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AITaskOrganizerTypography,
        content = content
    )
}
