package com.zogik.shoescompose.home.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.zogik.shoescompose.R
import com.zogik.shoescompose.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, route: Route) {
    CenterAlignedTopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            if (route != Route.HOME) {
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(R.drawable.ic_backbutton), "back")
                }
            }
        },
        actions = {
            if (route == Route.HOME) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_person_pin_24),
                        contentDescription = "profile",
                    )
                }
            }
        },
    )
}

@Preview
@Composable
fun previewTopBar() {
    TopBar(Route.HOME.title, Route.HOME)
}
