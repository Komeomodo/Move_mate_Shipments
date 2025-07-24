package com.example.movemateshipments.ui.features.calculate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movemateshipments.TitledAppBar
import com.example.movemateshipments.ui.features.calculate.components.CalculateContentView
import com.example.movemateshipments.ui.theme.DirtyWhite

const val animate_duration = 500

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculateViewModel = viewModel(),
    navController: NavController,
) {
    var animateTopBar by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = "") {
        animateTopBar = true
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(DirtyWhite),
        topBar = {
            TitledAppBar(
                title = "Calculate",
                onBackClick = {
                    navController.popBackStack()
                },
                animateTopBar = animateTopBar
            )
        }
    ) { paddingValues ->
        CalculateContentView(
            paddingValues = paddingValues,
            viewModel = viewModel,
            navController = navController,
            animateWholeBody = animateTopBar
        )
    }
}