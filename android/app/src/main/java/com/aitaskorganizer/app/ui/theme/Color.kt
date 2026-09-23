package com.aitaskorganizer.app.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Neo-Brutalist / Bauhaus Color Palette
 */

// Core Colors
val BauhausWhite = Color(0xFFF5F0E8)     // Background
val BauhausBlack = Color(0xFF1A1A1A)     // Text and Outlines
val BauhausYellow = Color(0xFFFFCC00)    // Primary
val BauhausRed = Color(0xFFE63B2E)       // Secondary
val BauhausBlue = Color(0xFF0055FF)      // Tertiary

// Shadow Color
val BrutalShadow = Color(0xFF000000)

// Functional Colors
val ErrorRed = Color(0xFFE63B2E)
val SuccessGreen = Color(0xFF00C853)

// Semantic Assignments
val Background = BauhausWhite
val OnBackground = BauhausBlack

val Primary = BauhausYellow
val OnPrimary = BauhausBlack

val Secondary = BauhausRed
val OnSecondary = BauhausWhite

val Tertiary = BauhausBlue
val OnTertiary = BauhausWhite

val Surface = Color.White
val OnSurface = BauhausBlack

val Outline = BauhausBlack

// Priority Colors (Neo-Brutalist variants)
val PriorityUrgent = BauhausRed
val PriorityHigh = Color(0xFFFF8C00) // Deep Orange
val PriorityMedium = BauhausYellow
val PriorityLow = BauhausBlue
