package com.example.movemateshipments.Utils

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.example.movemateshipments.ui.features.calculate.animate_duration

@Composable
fun AnimatedVisibility(
    isListVisible: Boolean,
    content: @Composable () -> Unit
) {
    androidx.compose.animation.AnimatedVisibility(
        visible = isListVisible,
        enter = slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth },
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