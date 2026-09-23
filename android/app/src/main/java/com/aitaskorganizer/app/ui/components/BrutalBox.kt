package com.aitaskorganizer.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.BrutalShadow

/**
 * A Neo-Brutalist container box with a solid background, a hard black border,
 * and an offset crisp shadow ("brutal shadow").
 */
@Composable
fun BrutalBox(
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    borderColor: Color = Color(0xFF1A1A1A),
    borderWidth: Dp = AppDimens.BorderThickness,
    shadowOffset: Dp = AppDimens.ShadowOffset,
    cornerRadius: Dp = AppDimens.CornerRadiusNone,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)
    
    val baseModifier = modifier
        .drawBehind {
            // Draw crisp solid shadow manually for clean neo-brutalist styling
            val offsetPx = shadowOffset.toPx()
            if (cornerRadius == AppDimens.CornerRadiusNone) {
                drawRect(
                    color = BrutalShadow,
                    topLeft = Offset(offsetPx, offsetPx),
                    size = size
                )
            } else {
                val radiusPx = cornerRadius.toPx()
                drawRoundRect(
                    color = BrutalShadow,
                    topLeft = Offset(offsetPx, offsetPx),
                    size = size,
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(radiusPx, radiusPx)
                )
            }
        }
        .background(color = backgroundColor, shape = shape)
        .border(width = borderWidth, color = borderColor, shape = shape)

    val finalModifier = if (onClick != null) {
        baseModifier.clickable(onClick = onClick)
    } else {
        baseModifier
    }

    Box(modifier = finalModifier) {
        content()
    }
}
