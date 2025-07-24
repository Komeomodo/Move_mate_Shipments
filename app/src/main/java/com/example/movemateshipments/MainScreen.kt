package com.example.movemateshipments

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.movemateshipments.Utils.BottomBarAnimatedVisibility
import com.example.movemateshipments.ui.features.home.BottomNav

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var showBottomBar by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomBarAnimatedVisibility(visibility = showBottomBar) {
                BottomNav(navController = navController)
            }
        }
    ) {
        BottomNavGraph(navController = navController) {
            showBottomBar = it
        }
    }
}