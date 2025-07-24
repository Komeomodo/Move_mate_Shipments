package com.example.movemateshipments.ui.features.home.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movemateshipments.R
import com.example.movemateshipments.Utils.AnimateContentVisibility
import com.example.movemateshipments.ui.features.home.data.Vehicle
import com.example.movemateshipments.ui.theme.proxima

@Composable
fun AvailableLogisticView(
    modifier: Modifier = Modifier,
    vehicles: List<Vehicle>,
    isListVisible: Boolean,
    isAvailableVehiclesVisible: Boolean
) {
    val freightItemsXOffset: Dp by animateDpAsState(
        targetValue = if (isAvailableVehiclesVisible) 0.dp else 40.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "freightItemsXOffset"
    )
    val freightItemsYOffset: Dp by animateDpAsState(
        targetValue = if (isAvailableVehiclesVisible) 0.dp else 100.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "freightItemsXOffset"
    )
    val freightAlpha: Float by animateFloatAsState(
        targetValue = if (isAvailableVehiclesVisible) 1f else 0.1f,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "freightItemsXOffset"
    )

    Column(
    modifier = modifier
    ) {
        AnimateContentVisibility(isAvailableVehiclesVisible) {
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Available vehicles",
                fontSize = 17.sp,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = proxima,
                color = colorResource(id = R.color.black)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            Modifier
                .fillMaxWidth()
                .offset(x = freightItemsXOffset, y = freightItemsYOffset)
                .alpha(freightAlpha),
            contentPadding = PaddingValues(start = 20.dp)
        ) {
            items(items = vehicles) {
                FreightItem(
                    name = it.name,
                    status = it.status,
                    image = it.image,
                    isListVisible = isListVisible,
                )
                Spacer(Modifier.width(10.dp))
            }
        }
    }
}