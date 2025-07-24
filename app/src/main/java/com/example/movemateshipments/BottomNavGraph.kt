package com.example.movemateshipments

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movemateshipments.ui.features.calculate.CalculateScreen
import com.example.movemateshipments.ui.features.calculate.CostEstimateScreen
import com.example.movemateshipments.ui.features.home.HomeScreen
import com.example.movemateshipments.ui.features.home.SearchScreen
import com.example.movemateshipments.ui.features.shipment.ShipmentScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    showBottomBar: (state: Boolean) -> Unit
){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None }
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
            showBottomBar(true)
        }

        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(navController = navController, onBack = { showBottomBar(true) })
            showBottomBar(false)
        }

        composable(route = BottomBarScreen.Calculate.route) {
            CalculateScreen(navController = navController)
            showBottomBar(false)
        }

        composable(route = BottomBarScreen.Shipment.route) {
            ShipmentScreen(navController = navController)
            showBottomBar(false)
        }

        composable(route = BottomBarScreen.CostEstimate.route) {
            CostEstimateScreen(navController = navController)
            showBottomBar(false)
        }
    }
}