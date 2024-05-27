package com.ibrahimethemsen.pigeon.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ibrahimethemsen.models.Currency
import com.ibrahimethemsen.models.CurrencyType
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing
import com.ibrahimethemsen.pigeon.ui.sizing.LocalScalableSizing

@Composable
fun CurrencyCard(
    currencyList: List<Currency>
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = LocalDimensionSizing.current.scale16)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(LocalDimensionSizing.current.scale8)
            )
            .background(Color.White)
            .padding(LocalDimensionSizing.current.scale8)
            .requiredHeightIn(
                LocalDimensionSizing.current.scale2,
                LocalDimensionSizing.current.scale192
            ),
        verticalArrangement = Arrangement.spacedBy(LocalDimensionSizing.current.scale8)
    ) {
        itemsIndexed(currencyList) { index, item ->
            CurrencyRow(
                item.type,
                item.price.toString(),
            )
            if (index < currencyList.lastIndex)
                HorizontalDivider(modifier = Modifier.padding(top = LocalDimensionSizing.current.scale8))
        }
    }
}

@Composable
fun CurrencyRow(
    currencyType: CurrencyType,
    currencyAmount: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.LightGray)
                .padding(
                    top = LocalDimensionSizing.current.scale8,
                    start = LocalDimensionSizing.current.scale12,
                    end = LocalDimensionSizing.current.scale12,
                    bottom = LocalDimensionSizing.current.scale8
                ),
            text = currencyType.symbol,
            textAlign = TextAlign.Center,
            fontSize = LocalScalableSizing.current.scale20
        )
        Text(
            modifier = Modifier.padding(start = LocalDimensionSizing.current.scale12),
            text = "${currencyType.symbol}${currencyAmount}",
            textAlign = TextAlign.Center,
            fontSize = LocalScalableSizing.current.scale20
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PrevCurrency() {
    CurrencyCard(
        listOf(Currency(25, CurrencyType.TURKISH_LIRA), Currency(25, CurrencyType.DOLLAR))
    )
}