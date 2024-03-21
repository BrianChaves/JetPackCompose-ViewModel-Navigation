package com.example.jetpackcompose

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {

    fun generateRandomCor(): Color {
        return Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 1f
        )
    }
}