package com.ibrahimethemsen.pigeon.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahimethemsen.pigeon.R

@Composable
fun TransactionsRow(
    transferClick : () -> Unit,
    pullClick : () -> Unit,
    currencyReceiveSellClick : () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        TransactionButton(title = "Aktar", icon = Icons.Filled.KeyboardArrowUp, click = transferClick)
        TransactionButton(title = "Çek", icon = Icons.Filled.KeyboardArrowDown,pullClick)
        TransactionButton(title = "Döviz Al/Sat", icon = R.drawable.ic_exchange,currencyReceiveSellClick)
    }
}

@Composable
fun TransactionButton(
    title: String,
    icon: ImageVector,
    click: () -> Unit
) {
    OutlinedButton(onClick = {
        click.invoke()
    }) {
        Icon(imageVector = icon, contentDescription = "")
        TransactionText(title = title)
    }
}

@Composable
fun TransactionButton(
    title: String,
    @DrawableRes icon: Int,
    click: () -> Unit
) {
    OutlinedButton(onClick = {
        click.invoke()
    }) {
        Icon(painter = painterResource(id = icon), contentDescription = "")
        TransactionText(title = title)
    }
}

@Composable
fun TransactionText(
    title: String,
    color: Color = Color.Black
) {
    Text(text = title, color = color)
}

@Preview(showBackground = true)
@Composable
fun PrevTransactionsRow() {
    TransactionsRow(
        {},
        {},
        {}
    )
}