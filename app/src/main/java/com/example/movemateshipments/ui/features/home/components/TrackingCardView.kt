package com.example.movemateshipments.ui.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movemateshipments.R
import com.example.movemateshipments.ui.theme.Grey
import com.example.movemateshipments.ui.theme.Orange
import com.example.movemateshipments.ui.theme.proxima

@Composable
fun TrackingCardView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Tracking",
            style = MaterialTheme.typography.displayLarge,
            color = colorResource(R.color.black),
            fontFamily = proxima
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            Modifier
                .shadow(elevation = 3.dp)
                .clipToBounds()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Shipment Number", 
                        style = MaterialTheme.typography.bodyLarge.copy(color = Grey),
                        fontFamily = proxima
                    )
                    Text(
                        text = "NEJ200089934122231", 
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        fontFamily = proxima,
                        color = colorResource(id = R.color.black)
                    )
                }
                Image(painter = painterResource(id = R.drawable.ic_fork_lift), contentDescription = "fork lift icon", modifier = Modifier.size(40.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                Modifier
                    .padding(horizontal = 10.dp)
                    .height(1.dp)
                    .background(color = colorResource(id = R.color.very_light_brown))
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            TrackingItem(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                trackingType = TrackingType.SENDER,
                address = "Atlanta, 5243",
                duration = "2 day -3 days"
            )
            Spacer(modifier = Modifier.height(30.dp))
            TrackingItem(modifier = Modifier
                .padding(horizontal = 10.dp),
                trackingType = TrackingType.RECEIVER,
                address = "Chicago, 6342",
                duration = "Waiting to collect"
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                Modifier
                    .height(1.dp)
                    .background(color = colorResource(id = R.color.very_light_brown))
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "add",
                    tint = Orange,
                    modifier = Modifier.size(20.dp),
                )
                Text(text = "Add Stop",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Orange,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}