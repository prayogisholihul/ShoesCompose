package com.zogik.shoescompose.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import com.zogik.shoescompose.Route
import com.zogik.shoescompose.profile.component.ProfileScreen
import com.zogik.shoescompose.shared.TopBar
import com.zogik.shoescompose.ui.theme.ShoesComposeTheme

class ProfileActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoesComposeTheme {
                Surface {
                    Column {
                        TopBar(Route.PROFILE.title, Route.PROFILE, backPressed = {
                            onBackPressedDispatcher.onBackPressed()
                        })
                        ProfileScreen()
                    }
                }
            }
        }
    }
}
