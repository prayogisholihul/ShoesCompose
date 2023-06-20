package com.zogik.shoescompose.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zogik.shoescompose.Route
import com.zogik.shoescompose.Shoes
import com.zogik.shoescompose.home.component.BoxItem
import com.zogik.shoescompose.home.component.Search
import com.zogik.shoescompose.home.component.TopBar
import com.zogik.shoescompose.ui.theme.ShoesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoesComposeTheme {
                val viewModel = viewModel<ViewModel>()
                val shoesFilter by viewModel.shoes.collectAsState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column {
                        TopBar(Route.HOME.title, Route.HOME)
                        Search(Modifier, viewModel)
                        CardItem(shoesFilter)
                    }
                }
            }
        }
    }
}

@Composable
private fun CardItem(shoesList: List<Shoes>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp,
        ),
    ) {
        items(shoesList) {
            BoxItem(Modifier, it) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ShoesComposeTheme {}
}
