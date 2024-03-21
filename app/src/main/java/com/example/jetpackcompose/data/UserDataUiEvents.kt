package com.example.jetpackcompose.data

//Maneja Eventos
sealed class UserDataUiEvents {
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class LanguajeSelected(val languajeValue: String) : UserDataUiEvents()

}