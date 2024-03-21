package com.example.jetpackcompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.UserDataUiEvents
import com.example.jetpackcompose.ui.*

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {

            // Barra superior de la pantalla
            TopBar("Hola \uD83D\uDE0A")
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                textValue = "Vamos a conocer algo nuevo sobre Aplicaciones Moviles",
                textSize = 24.sp
            )

            // Espacio flexible para expandir
            Spacer(modifier = Modifier.size(40.dp))

            // Texto de introducción
            TextComponent(textValue = "Nombre", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "Seleccioar Lenguaje de Programacion", textSize = 18.sp)

            // Filas de cartas de lenguaje de programación
            Row(modifier = Modifier.fillMaxWidth()) {
                LanguajeCard(
                    image = painterResource(id = R.drawable.dart),
                    languageName = "Dart",
                    selected = userInputViewModel.uiState.value.languajeSelected == "Dart",
                    onCardClick = { userInputViewModel.onEvent(UserDataUiEvents.LanguajeSelected(it)) }
                )
                LanguajeCard(
                    image = painterResource(id = R.drawable.kotlin),
                    languageName = "Kotlin",
                    selected = userInputViewModel.uiState.value.languajeSelected == "Kotlin",
                    onCardClick = { userInputViewModel.onEvent(UserDataUiEvents.LanguajeSelected(it)) }
                )
                LanguajeCard(
                    image = painterResource(id = R.drawable.swift),
                    languageName = "Swift",
                    selected = userInputViewModel.uiState.value.languajeSelected == "Swift",
                    onCardClick = { userInputViewModel.onEvent(UserDataUiEvents.LanguajeSelected(it)) }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Botón para avanzar a la pantalla de bienvenida si los datos son válidos
            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailScreen = {
                        println("Los datos vienen")
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.languajeSelected,
                            )
                        )
                    }
                )
            }


        }


    }


}
/*
@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(UserInputViewModel())
}*/