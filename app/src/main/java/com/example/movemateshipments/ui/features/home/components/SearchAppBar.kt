package com.example.movemateshipments.ui.features.home.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.movemateshipments.R
import com.example.movemateshipments.ui.theme.Grey
import com.example.movemateshipments.ui.theme.Orange
import com.example.movemateshipments.ui.theme.Transparent

@Composable
fun SearchAppBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onClick: () -> Unit,
    animateTopBar: Boolean
) {
    var animateAppBar by remember { mutableStateOf(false) }
    val appBarHeight: Dp by animateDpAsState(
        targetValue = if (animateAppBar) 55.dp else 120.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "appBarHeight"
    )
    val searchBarPosition by animateDpAsState(
        targetValue = if(animateAppBar) 0.dp else 60.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "searchBarPosition"
    )
    val searchBarPaddingStart by animateDpAsState(
        targetValue = if(animateAppBar) 50.dp else 20.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "paddingStart"
    )

    LaunchedEffect(key1 = "") {
        animateAppBar = true
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(end = 12.dp, top = 16.dp, bottom = 20.dp)
                .height(appBarHeight),
            contentAlignment = Alignment.TopStart
        ) {
            androidx.compose.animation.AnimatedVisibility(
                visible = animateTopBar,
                enter = slideInHorizontally(
                    initialOffsetX = { w -> -w },
                    animationSpec = tween(durationMillis = 500)
                ) + fadeIn(
                    tween(500),
                ),
                exit = slideOutHorizontally(tween(durationMillis = 500)) + fadeOut(tween(500))
            ) {
                IconButton(onClick = onClick, modifier = Modifier.size(50.dp).padding(top = 10.dp)) {
                    Icon(Icons.Default.KeyboardArrowLeft, tint = Color.White, contentDescription = null)
                }
            }

            TextField(
                value = searchQuery, onValueChange = onSearchQueryChange,
                placeholder = {
                    Text(
                        text = "Enter the receipt number ...",
                        modifier = Modifier
                            .background(color = Transparent),
                        style = typography.titleMedium.copy(color = Grey),
                        overflow = TextOverflow.Ellipsis
                    )
                },
                modifier = Modifier
                    .padding(end = 8.dp, start = searchBarPaddingStart)
                    .fillMaxWidth()
                    .height(56.dp)
                    .offset(y = searchBarPosition)
                    .clip(RoundedCornerShape(48.dp))
                    .focusRequester(remember { FocusRequester() })
                    .clickable { },
                leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = "Search") },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedPlaceholderColor = Color.Gray.copy(0.8f),
                    unfocusedPlaceholderColor = Color.Gray.copy(0.8f),
                    focusedTextColor = Color.Gray.copy(alpha = 0.8f),
                ),
                trailingIcon = {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                            .background(Orange)
                            .size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_flip),
                            contentDescription = "Scanner flip",
                            tint = Color.White,
                            modifier = Modifier
                                .size(20.dp)
                                .rotate(90f)
                        )
                    }
                }
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
    }
}