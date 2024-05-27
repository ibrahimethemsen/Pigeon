package com.ibrahimethemsen.pigeon.trackinglist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ibrahimethemsen.pigeon.home.PigeonTitleActionRow
import com.ibrahimethemsen.pigeon.icon.PigeonIconVector
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing

@Composable
fun TrackingListComponent() {
    Column {
        PigeonTitleActionRow(title = "Takip Listeleri", actionTitle = "Ekle", icon = {
            PigeonIconVector(
                icon = Icons.Filled.Add
            )
        }) {

        }
        LazyRow(
            modifier = Modifier.padding(
                top = LocalDimensionSizing.current.scale8,
                bottom = LocalDimensionSizing.current.scale16
            ),
            horizontalArrangement = Arrangement.spacedBy(LocalDimensionSizing.current.scale8)
        ) {
            items(4) {
                Card(
                    elevation = CardDefaults.elevatedCardElevation(LocalDimensionSizing.current.scale4),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(LocalDimensionSizing.current.scale12)
                    ) {
                        Text(text = "Liste Adı")
                        Text(text = "(2)")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevTrackingListComponent() {
    TrackingListComponent()
}