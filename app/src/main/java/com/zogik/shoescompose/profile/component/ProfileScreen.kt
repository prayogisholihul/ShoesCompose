package com.zogik.shoescompose.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.zogik.shoescompose.R
import com.zogik.shoescompose.shared.backgroundDetail

@Composable
fun ProfileScreen() {
    val background = "background"
    val image = "image"
    val personalData = "personalData"

    val constraintSet = ConstraintSet {
        val backgroundSet = createRefFor(background)
        val imageSet = createRefFor(image)
        val personalDataSet = createRefFor(personalData)

        constrain(backgroundSet) {
            width = Dimension.wrapContent
            height = Dimension.wrapContent
            bottom.linkTo(parent.bottom)
        }

        constrain(imageSet) {
            start.linkTo(backgroundSet.start)
            end.linkTo(backgroundSet.end)
            bottom.linkTo(backgroundSet.top)
        }

        constrain(personalDataSet) {
            top.linkTo(imageSet.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }

    ConstraintLayout(constraintSet = constraintSet, modifier = Modifier.fillMaxSize()) {
        backgroundDetail(modifier = Modifier.layoutId(background))
        Image(
            modifier = Modifier.layoutId(image)
                .width(250.dp)
                .height(250.dp)
                .offset(y = 120.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.foto_diri),
            contentDescription = "fotoDiri",
        )
        personalData(Modifier.layoutId(personalData).offset(y = 150.dp))
    }
}

@Composable
private fun personalData(modifier: Modifier) {
    Column(modifier) {
        OutlinedTextField(
            modifier = Modifier.padding(bottom = 16.dp),
            value = "Prayogi Sholihul Insan",
            readOnly = true,
            label = {
                Text("Name")
            },
            onValueChange = {},
        )
        OutlinedTextField(
            value = "prayogisholihul@gmail.com",
            readOnly = true,
            label = {
                Text("Email")
            },
            onValueChange = {},
        )
    }
}

@Preview
@Composable
fun previewProfileScreen() {
    ProfileScreen()
}
