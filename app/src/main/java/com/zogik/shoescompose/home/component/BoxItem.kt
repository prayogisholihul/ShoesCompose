package com.zogik.shoescompose.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zogik.shoescompose.R
import com.zogik.shoescompose.Shoes
import com.zogik.shoescompose.ui.theme.appMainColor

@Composable
fun BoxItem(
    modifier: Modifier,
    shoes: Shoes,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.width(150.dp).height(200.dp).clip(RoundedCornerShape(16.dp))
            .background(appMainColor).padding(4.dp).clickable {
                onClick.invoke()
            },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(shoes.pic),
                modifier = Modifier.width(150.dp).height(100.dp).padding(top = 12.dp),
                contentDescription = "shoes",
            )
            Spacer(Modifier.padding(top = 20.dp))
            Text(shoes.name, fontSize = 12.sp)
            Spacer(Modifier.padding(top = 6.dp))
            Text(text = "$${shoes.price}", fontSize = 12.sp)
        }
    }
}

@Preview
@Composable
fun PreviewBackground() {
    BoxItem(
        Modifier.fillMaxSize(),
        shoes = Shoes(
            name = "Nike Air Force 1",
            desc = "oke",
            size = "42",
            price = 150.0,
            pic = R.drawable.adidas_air_force,
        ),
        onClick = {},
    )
}
