package com.example.movemateshipments.ui.features.home

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.movemateshipments.Utils.AnimateContentVisibility
import com.example.movemateshipments.ui.features.home.components.SavedSearchItemsView
import com.example.movemateshipments.ui.features.home.components.SearchAppBar
import com.example.movemateshipments.ui.theme.DirtyWhite

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SearchViewModel = viewModel(),
    onBack: () -> Unit,
) {
    var isContentVisible by remember { mutableStateOf(false) }
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    var animateTopBar by remember { mutableStateOf(false) }

    LaunchedEffect("") {
        isContentVisible = true
        animateTopBar = true
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(DirtyWhite),
        topBar = {
            SearchAppBar(
                searchQuery = viewModel.searchQuery,
                onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
                onClick = {
                    onBack()
                    navController.popBackStack()
                },
                animateTopBar = animateTopBar
            )
        },
    ) { paddingValues ->
        AnimateContentVisibility(visibility = isContentVisible) {
            SavedSearchItemsView(searchResults, paddingValues)
        }
    }
}