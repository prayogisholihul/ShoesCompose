package com.zogik.shoescompose.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.zogik.shoescompose.Shoes
import com.zogik.shoescompose.ui.theme.appMainColor
import com.zogik.shoescompose.utils.semiBorder

@Composable
fun DetailScreen(shoes: Shoes) {
    val background = "background"
    val image = "image"
    val contentText = "text"

    val constraint = ConstraintSet {
        val backgroundSet = createRefFor(background)
        val imageSet = createRefFor(image)
        val contextTextSet = createRefFor(contentText)

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

        constrain(contextTextSet) {
            start.linkTo(backgroundSet.start)
            end.linkTo(backgroundSet.end)
            top.linkTo(imageSet.bottom)
            bottom.linkTo(parent.bottom)
        }
    }

    ConstraintLayout(constraintSet = constraint, modifier = Modifier.fillMaxSize()) {
        backgroundDetail(modifier = Modifier.layoutId(background))
        Image(
            modifier = Modifier.layoutId(image).width(270.dp).height(250.dp).offset(y = 120.dp),
            painter = painterResource(shoes.pic),
            contentDescription = image,
        )
        contentDetail(
            shoes,
            Modifier.layoutId(contentText).padding(start = 48.dp, end = 48.dp, top = 120.dp),
        )
    }
}

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

@Preview(Devices.PIXEL_2)
@Composable
fun detailPreview() {
    DetailScreen(Shoes())
}
