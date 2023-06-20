package com.zogik.shoescompose.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import com.zogik.shoescompose.Route
import com.zogik.shoescompose.Shoes
import com.zogik.shoescompose.detail.component.DetailScreen
import com.zogik.shoescompose.ui.theme.ShoesComposeTheme
import com.zogik.shoescompose.utils.TopBar
import com.zogik.shoescompose.utils.parcelable

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shoesData: Shoes = intent.parcelable(EXTRA_DATA) ?: Shoes()

        setContent {
            ShoesComposeTheme {
                Surface {
                    Column {
                        TopBar(Route.DETAIL.title, Route.DETAIL, backPressed = {
                            onBackPressedDispatcher.onBackPressed()
                        })
                        DetailScreen(shoesData)
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
