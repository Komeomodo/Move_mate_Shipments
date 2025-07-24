package com.example.movemateshipments.ui.features.shipment

import androidx.lifecycle.ViewModel
import com.example.movemateshipments.ui.features.shipment.data.ShipmentStatus
import com.example.movemateshipments.ui.features.shipment.data.ShipmentStatusLabel
import com.example.movemateshipments.ui.features.shipment.data.listOfShipmentStatus

class ShipmentViewModel: ViewModel() {
    fun updatedStatusLabelList(selectedId: Int): List<ShipmentStatus> {
        val selectedStatusLabel =
            ShipmentStatusLabel.entries.find { label -> label.id == selectedId }
                ?: ShipmentStatusLabel.ALL

        return if (selectedStatusLabel == ShipmentStatusLabel.ALL)
            listOfShipmentStatus
        else
            listOfShipmentStatus.filter { it.status == selectedStatusLabel }
    }
}