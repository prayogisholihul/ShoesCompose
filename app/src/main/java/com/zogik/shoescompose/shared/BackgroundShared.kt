package com.zogik.shoescompose.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zogik.shoescompose.ui.theme.appMainColor

@Composable
fun backgroundDetail(modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(
            topEnd = 48.dp,
            topStart = 48.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp,
        ),
        modifier = modifier
            .semiBorder(1.dp, Color.Transparent, 10.dp).padding(horizontal = 24.dp),

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .background(appMainColor),
            contentAlignment = Alignment.Center,
        ) {}
    }
}
