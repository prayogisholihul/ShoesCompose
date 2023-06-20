package com.zogik.shoescompose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoes(
    var name: String = "",
    var desc: String = "",
    var size: String = "",
    var price: Double = 0.00,
    var pic: Int = 0,
) : Parcelable {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            name,
            size,
            "$price",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
