package com.example.movemateshipments.ui.features.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movemateshipments.BottomBarScreen
import com.example.movemateshipments.Utils.AnimateContentVisibility
import com.example.movemateshipments.ui.features.home.components.AvailableLogisticView
import com.example.movemateshipments.ui.features.home.components.HomeHeaderView
import com.example.movemateshipments.ui.features.home.components.TrackingCardView
import com.example.movemateshipments.ui.features.home.data.vehiclesList
import com.example.movemateshipments.ui.theme.DirtyWhite
import com.example.movemateshipments.ui.theme.MoveMateShipmentsTheme

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MoveMateShipmentsTheme {
//        HomeScreen(
//            navController = NavHostController,
//            modifier = Modifier
//        )
    }
}


@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = DirtyWhite)
            .fillMaxSize()
    ) {
        var isListVisible by remember { mutableStateOf(false) }
        var isContentVisible by remember { mutableStateOf(false) }
        var isAppBarVisible by remember { mutableStateOf(false) }

        var containerState by remember { mutableStateOf(HomeViewState.HOME) }

        LaunchedEffect("") {
            isContentVisible = !isContentVisible
            isAppBarVisible = !isAppBarVisible
            isListVisible = true
        }

        AnimatedContent(
            modifier = Modifier,
            targetState = containerState,
            label = "container transform",
        ) { state ->
            when (state) {
                HomeViewState.HOME -> AnimateContentVisibility(
                    visibility = isAppBarVisible,
                ) {
                    HomeHeaderView(
                        onSearchClick = {
                            containerState = HomeViewState.HOME
                            navController.navigate(BottomBarScreen.Search.route)
                        }
                    )
                }

                HomeViewState.SEARCH -> SearchScreen(
                    navController = navController,
                    onBack = {
                        containerState = HomeViewState.SEARCH
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimateContentVisibility(visibility = isContentVisible) {
            Column {
                TrackingCardView(modifier = Modifier.padding(horizontal = 20.dp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        AvailableLogisticView(
            vehicles = vehiclesList,
            isListVisible = isListVisible,
            isAvailableVehiclesVisible = isContentVisible
        )


    }
}