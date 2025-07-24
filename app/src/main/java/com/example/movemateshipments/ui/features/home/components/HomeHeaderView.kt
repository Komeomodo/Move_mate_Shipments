package com.example.movemateshipments.ui.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movemateshipments.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HomeHeaderPreview() {
    HomeHeaderView(onSearchClick = {})
}

@Composable
fun HomeHeaderView(
    onSearchClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .statusBarsPadding()
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier,
        ) {
            Row(
                modifier = Modifier
                    .size(50.dp)
                    .weight(1f)
            ) {
                Image(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.ic_profile_picture),
                    contentDescription = "User profile picture",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(12.dp))
                Column(
                    modifier = Modifier.height(40.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Your location",
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.White.copy(alpha = 0.7f)
                            )
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Wertheimer, Illinois",
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = "location",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }


                }
            }
            Box(
                modifier = Modifier
                    .background(Color.White, shape = CircleShape)
                    .size(40.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "notification"
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        SearchBarView(onSearchClick = { onSearchClick() })

    }

}