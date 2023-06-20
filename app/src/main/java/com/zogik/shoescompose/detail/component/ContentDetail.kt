package com.zogik.shoescompose.detail.component

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zogik.shoescompose.Shoes

@Composable
fun contentDetail(shoes: Shoes, modifier: Modifier) {
    val context = LocalContext.current
    val scroll = rememberScrollState(0)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(shoes.name)
        Spacer(Modifier.padding(bottom = 24.dp))
        Text(
            modifier = Modifier.fillMaxHeight(0.35f).verticalScroll(scroll),
            textAlign = TextAlign.Center,
            text = shoes.desc,
        )
        Spacer(Modifier.padding(bottom = 24.dp))
        Text("Size: ${shoes.size}")
        Text("$${shoes.price}")

        Spacer(Modifier.padding(bottom = 12.dp))
        Button(
            modifier = Modifier.height(36.dp).fillMaxWidth(0.5f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
            ),
            onClick = {
                Toast.makeText(context, "Thank you", Toast.LENGTH_SHORT).show()
            },
        ) {
            Text("BUY NOW")
        }
        Spacer(Modifier.padding(bottom = 16.dp))
    }
}

@Preview
@Composable
fun previewContentDetail() {
    contentDetail(Shoes(), Modifier)
}
