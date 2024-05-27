package com.ibrahimethemsen.pigeon.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahimethemsen.pigeon.R
import com.ibrahimethemsen.pigeon.model.TotalBalanceUI
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing
import com.ibrahimethemsen.pigeon.ui.sizing.LocalScalableSizing
import com.ibrahimethemsen.pigeon.ui.theme.PigeonBgWhite
import com.ibrahimethemsen.pigeon.ui.theme.PigeonGreen
import com.ibrahimethemsen.pigeon.ui.theme.PigeonRed

val COLLAPSED_TOP_BAR_HEIGHT = 60.dp
val EXPANDED_TOP_BAR_HEIGHT = 100.dp

@Composable
fun CollapsedTopBar(
    price: TotalBalanceUI,
    isCollapsed: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(
                start = LocalDimensionSizing.current.scale16,
                end = LocalDimensionSizing.current.scale16
            )
            .background(PigeonBgWhite)
            .padding(top = LocalDimensionSizing.current.scale16)
            .fillMaxWidth()
            .height(COLLAPSED_TOP_BAR_HEIGHT),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AnimatedVisibility(
            visible = isCollapsed,
            enter = slideInVertically(
                initialOffsetY = { it },
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(LocalDimensionSizing.current.scale8)
            ) {
                Text(
                    text = "₺" + price.price,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "₺" + price.change,
                    color = if (price.isMinus) {
                        PigeonRed
                    } else PigeonGreen,
                    fontSize = LocalScalableSizing.current.scale14
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(LocalDimensionSizing.current.scale28),
            painter = painterResource(id = R.drawable.ic_pigeon),
            contentDescription = ""
        )
    }
}

@Composable
fun ExpandedTopBar(price: TotalBalanceUI) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PigeonBgWhite),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Yatırım Hesabı",
            color = Color.Black,
        )
        Text(
            text = price.price,
            color = Color.Black,
            style = MaterialTheme.typography.headlineLarge,
        )
        Text(
            text = price.change,
            color = if (price.isMinus) {
                PigeonRed
            } else PigeonGreen,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 16.sp
        )
    }
}