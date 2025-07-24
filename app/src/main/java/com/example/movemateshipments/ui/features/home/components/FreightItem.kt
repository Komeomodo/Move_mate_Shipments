package com.example.movemateshipments.ui.features.home.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movemateshipments.Utils.AnimatedVisibility
import com.example.movemateshipments.ui.theme.Grey
import com.example.movemateshipments.ui.theme.Transparent
import com.example.movemateshipments.ui.theme.proxima

@Composable
fun FreightItem(
    modifier: Modifier = Modifier,
    name: String,
    status: String,
    image: Int,
    isListVisible: Boolean,
) {
    Column(
        modifier = modifier
            .shadow(5.dp)
            .width(140.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .clipToBounds()
            .background(color = Color.White)
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
            text = name,
            style = MaterialTheme.typography.bodyLarge
            .copy(
                color = Color.Black,
                fontWeight = FontWeight.W600,
                fontFamily = proxima
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = status,
            style = MaterialTheme.typography.labelSmall.copy(
                color = Grey,
                fontSize = 16.sp,
                fontFamily = proxima
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Box(
            Modifier
                .clipToBounds()
                .clip(RoundedCornerShape(16.dp))
                .background(color = Transparent)
        ) {
            AnimatedVisibility(isListVisible = isListVisible) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "freight image",
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(x = 40.dp)
                        .scale(1.2f)
                        .background(Transparent)
                )
            }
        }
    }
}