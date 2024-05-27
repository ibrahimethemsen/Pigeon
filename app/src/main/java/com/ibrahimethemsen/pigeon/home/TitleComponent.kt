package com.ibrahimethemsen.pigeon.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahimethemsen.pigeon.R
import com.ibrahimethemsen.pigeon.icon.PigeonIconDrawable
import com.ibrahimethemsen.pigeon.ui.sizing.LocalScalableSizing
import com.ibrahimethemsen.pigeon.ui.theme.PigeonBlue

@Composable
fun TitleText(
    title: String,
) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = LocalScalableSizing.current.scale24
    )
}

@Composable
fun PigeonTitleActionRow(
    title: String,
    actionTitle: String,
    icon: @Composable () -> Unit,
    actionClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TitleText(title = title)
        Row(
            modifier = Modifier.clickable { actionClick.invoke() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = actionTitle, color = PigeonBlue)
            icon()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevPigeonTitleActionRow() {
    PigeonTitleActionRow("Pigeon Title", "Pigeon", {
        PigeonIconDrawable(icon = R.drawable.ic_pigeon)
    }) {

    }
}