package com.example.jetpackcompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.ui.*

@Composable
fun WelcomeScreen(username: String?, languajeSelected: String?) {
    println("////////////////////")
    println("$username and $languajeSelected")

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {

            TopBar(value = "Bienvenido $username \uD83D\uDE0A")

            TextComponent(textValue = "La aplicacion accedio a sus datos anteriores", textSize = 24.sp)

            Spacer(modifier = Modifier.size(20.dp))

            // Texto que muestra el lenguaje de programación seleccionado
            val finalText = "El lenguage de programacion seleccionado fue: $languajeSelected"
            TextWithShadow(value = finalText)

            // ViewModel para generar datos aleatorios sobre el lenguaje seleccionado
            val factsViewModel: FactsViewModel = viewModel()

            // Componente para mostrar datos aleatorios
            FactComposable(
                value = factsViewModel.generateRandomFacts(languajeSelected!!)

            )


        }

    }

}

@Preview
@Composable
fun UserWelcomePreview() {
    WelcomeScreen("username", "languajeSelected")
}