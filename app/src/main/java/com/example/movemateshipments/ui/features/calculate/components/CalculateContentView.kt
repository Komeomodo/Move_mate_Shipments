package com.example.movemateshipments.ui.features.calculate.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movemateshipments.BottomBarScreen
import com.example.movemateshipments.R
import com.example.movemateshipments.ui.features.calculate.CalculateViewModel
import com.example.movemateshipments.ui.features.calculate.animate_duration
import com.example.movemateshipments.ui.theme.DirtyWhite
import com.example.movemateshipments.ui.theme.Transparent
import com.example.movemateshipments.ui.theme.proxima

@Composable
fun CalculateContentView (
    paddingValues: PaddingValues,
    viewModel: CalculateViewModel,
    navController: NavController,
    animateWholeBody: Boolean
) {
    val topBarBgHeight: Dp by animateDpAsState(
        targetValue = if (animateWholeBody) 0.dp else 185.dp,
        animationSpec = tween(
            durationMillis = animate_duration,
            easing = LinearOutSlowInEasing
        ),
        label = "tabBarYOffset"
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .navigationBarsPadding()
            .background(DirtyWhite),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary)
                .height(topBarBgHeight)
        )

        AnimatedVisibility(
            visible = animateWholeBody,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight - 1000 },
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
            Column(
                Modifier
                    .padding(top = paddingValues.calculateTopPadding())
                    .padding(16.dp)
            ) {
                Text(
                    text = "Destination",
                    style = typography.titleLarge,
                    fontFamily = proxima,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.size(12.dp))
                Box(
                    modifier = Modifier
                        .shadow(elevation = 3.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        MoveMateTextField(
                            textValue = viewModel.senderLocation,
                            onValChange = { newVal -> viewModel.updateSenderLocation(newVal) },
                            placeHolder = "Sender location",
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_panel),
                                    contentDescription = "",
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    tint = Color.Gray
                                )
                            },
                        )
                        MoveMateTextField(
                            textValue = viewModel.receiverLocation,
                            onValChange = { newVal -> viewModel.updateReceiverLocation(newVal) },
                            placeHolder = "Receiver location",
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_panel),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .rotate(180f),
                                    tint = Color.Gray
                                )
                            },
                        )

                        MoveMateTextField(
                            textValue = viewModel.weight,
                            onValChange = { newVal -> viewModel.updateWeight(newVal) },
                            placeHolder = "Approx weight",
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_scale),
                                    contentDescription = "",
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    tint = Color.Gray
                                )
                            },
                        )
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Packaging",
                    style = typography.titleLarge,
                    fontFamily = proxima,
                    color = Color.Black,
                )
                Text(
                    text = "What are you sending?",
                    color = Color.Gray,
                    fontFamily = proxima,
                    style = typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Surface(
                    modifier = Modifier
                        .shadow(elevation = 5.dp)
                        .clipToBounds()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .height(56.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .fillMaxWidth()
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_box),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(30.dp)
                        )
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(vertical = 12.dp)
                                .width(1.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Box",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .background(Transparent)
                                .weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = "arrowDown",
                            tint = DividerDefaults.color
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
                // Drop down panel
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Categories",
                    style = typography.titleLarge,
                    color = Color.Black,
                    fontFamily = proxima,
                )
                Text(
                    text = "What are you sending?",
                    color = Color.Gray,
                    style = typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                    fontFamily = proxima
                )
            }
        }

        AnimatedVisibility(
            modifier = Modifier.padding(horizontal = 16.dp),
            visible = animateWholeBody,
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
            FilterChipGroup(items = viewModel.categories)
        }

        Spacer(modifier = Modifier.weight(1f))


        AnimatedVisibility(
            visible = animateWholeBody,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight},
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ) + fadeIn(
                initialAlpha = 0f,
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ) + fadeOut(
                targetAlpha = 0f,
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ),
        ) {
            MoveMateButton(
                modifier = Modifier,
                text = "Calculate"
            ) {
                navController.navigate(BottomBarScreen.CostEstimate.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}