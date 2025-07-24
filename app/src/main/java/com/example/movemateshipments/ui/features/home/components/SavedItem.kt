package com.example.movemateshipments.ui.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movemateshipments.R
import com.example.movemateshipments.ui.features.home.data.Item
import com.example.movemateshipments.ui.theme.NavyBlue

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SavedItem(
    item: Item,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .size(35.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_box_dark),
                modifier = Modifier.size(20.dp),
                contentDescription = null,
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            Text(text = item.name, color = NavyBlue, style = typography.titleLarge)
            Spacer(modifier = Modifier.size(4.dp))
            FlowRow(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top
            ) {
                Text(text = item.id, color = Color.Gray, style = typography.bodyLarge)
                Spacer(modifier = Modifier.size(6.dp))
                Box(
                    modifier = modifier
                        .size(5.dp)
                        .padding(top = 5.dp)
                        .clip(shape = CircleShape)
                        .background(color = Color.Gray),
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(text = item.origin, color = Color.Gray, style = typography.bodyLarge)
                Spacer(modifier = Modifier.size(6.dp))
                Icon(
                    Icons.Default.ArrowForward,
                    modifier = Modifier.size(12.dp),
                    tint = Color.Gray,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(text = item.destination, color = Color.Gray, style = typography.bodyLarge)
            }
        }
    }
}