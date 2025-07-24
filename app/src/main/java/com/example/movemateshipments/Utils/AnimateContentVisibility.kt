package com.example.movemateshipments.Utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.example.movemateshipments.ui.features.calculate.animate_duration

@Composable
fun AnimateContentVisibility(
    visibility: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visibility,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight},
            animationSpec = tween(durationMillis = animate_duration, easing = LinearOutSlowInEasing)
        ) + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = animate_duration, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = animate_duration, easing = LinearOutSlowInEasing)
        ) + fadeOut(
            targetAlpha = 0f,
            animationSpec = tween(durationMillis = animate_duration, easing = LinearOutSlowInEasing)
        ),
    ) {
        content()
    }
}