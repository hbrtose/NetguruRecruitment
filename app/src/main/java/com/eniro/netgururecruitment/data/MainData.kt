package com.eniro.netgururecruitment.data

import android.graphics.Color

object MainData {
    val cities = listOf("Gdańsk", "Warszawa", "Poznań", "Białystok", "Wrocław", "Katowice", "Kraków")
    val colors = listOf("Yellow", "Green", "Blue", "Red", "Black", "White")
    val colorMap = hashMapOf(
        "Yellow" to Color.YELLOW,
        "Green" to Color.GREEN,
        "Blue" to Color.BLUE,
        "Red" to Color.RED,
        "Black" to Color.BLACK,
        "White" to Color.WHITE
    )
}