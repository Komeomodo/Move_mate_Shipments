package com.example.movemateshipments.ui.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movemateshipments.R
import com.example.movemateshipments.Utils.noRippleClickable
import com.example.movemateshipments.ui.theme.Grey
import com.example.movemateshipments.ui.theme.Orange
import com.example.movemateshipments.ui.theme.Transparent
import com.example.movemateshipments.ui.theme.proxima

@Preview
@Composable
fun SearchBarPreview() {
    SearchBarView(onSearchClick = {})
}

@Composable
fun SearchBarView(onSearchClick: () -> Unit = {}) {
    val focusRequester = remember { FocusRequester() }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(48.dp))
            .noRippleClickable { onSearchClick.invoke() }
            .focusRequester(focusRequester),
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        placeholder = {
            Text(
                text = "Enter the receipt number ...",
                modifier = Modifier
                    .background(color = Transparent),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Grey,
                    fontFamily = proxima
                ),
                overflow = TextOverflow.Ellipsis
            )
        },
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
                    modifier = Modifier
                        .size(20.dp)
                        .rotate(90f),
                    painter = painterResource(id = R.drawable.ic_flip),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white)
                )
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedPlaceholderColor = Color.Gray.copy(0.8f),
            unfocusedPlaceholderColor = Color.Gray.copy(0.8f),
            cursorColor = Color.Black
        )
    )
}