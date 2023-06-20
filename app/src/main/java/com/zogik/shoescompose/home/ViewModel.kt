package com.zogik.shoescompose.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zogik.shoescompose.ShoesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    private val _shoes = MutableStateFlow(ShoesData.listData)
    val shoes = searchText
        .combine(_shoes) { text, shoes ->
            if (text.isBlank()) {
                shoes
            } else {
                shoes.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _shoes.value,
        )
}
