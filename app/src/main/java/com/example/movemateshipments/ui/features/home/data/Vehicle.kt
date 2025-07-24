package com.example.movemateshipments.ui.features.home.data

import com.example.movemateshipments.R

data class Vehicle(
    val name: String,
    val status: String,
    val image: Int
)

val vehiclesList = listOf(
    Vehicle("Ocean freight", "International", R.drawable.ship),
    Vehicle("Cargo freight", "Reliable", R.drawable.ic_truck),
    Vehicle("Air freight", "International", R.drawable.plane),
    Vehicle("Rail freight", "Reliable", R.drawable.train),
)
