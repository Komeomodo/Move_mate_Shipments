package com.example.movemateshipments.ui.features.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movemateshipments.ui.features.calculate.animate_duration
import com.example.movemateshipments.ui.features.home.data.Item

@Composable
fun SavedSearchItemsView(
    items: List<Item>,
    paddingValues: PaddingValues,
) {
    AnimatedContent(targetState = items, label = "", transitionSpec = {
        ContentTransform(
            targetContentEnter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight },
                animationSpec = tween(durationMillis = animate_duration, easing = LinearOutSlowInEasing)
            ) + fadeIn(
                initialAlpha = 0f,
                animationSpec = tween(durationMillis = animate_duration, easing = LinearOutSlowInEasing)
            ),
            initialContentExit = slideOutVertically(
                targetOffsetY = { h -> h },
                animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
            ) + fadeOut(
                targetAlpha = 0f,
                animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
            ),
        )
    }) { newList ->
        Surface(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(12.dp))
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                items(
                    count = newList.size,
                    key = { index -> newList[index].name },
                    itemContent = { index ->
                        val item = newList[index]
                        SavedItem(item = item)
                        if (index < newList.lastIndex) {
                            Spacer(modifier = Modifier.size(12.dp))
                            Divider(color = Color.Gray.copy(0.4f), thickness = 1.dp)
                        }
                    }
                )
            }
        }
    }
}