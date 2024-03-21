package com.example.jetpackcompose.ui

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.data.UserDataUiEvents
import com.example.jetpackcompose.data.UserInputScreenState
/**
 * ViewModel utilizado para manejar el estado de la pantalla de entrada de usuario.
 */
class UserInputViewModel : ViewModel() {

    companion object {
        const val TAG = "UserInputViewModel"
    }

    var uiState = mutableStateOf(UserInputScreenState())
    /**
     * Función que maneja los eventos de la IU, como la introducción del nombre de
     * usuario o la selección del lenguaje.
     *
     * @param events El evento de IU que se está procesando.
     */
    fun onEvent(events: UserDataUiEvents) {
        when (events) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = events.name
                )
                Log.d(TAG, "onEvent:UserNameEntered ->> ")
                Log.d(TAG, "${uiState.value} ")

            }

            is UserDataUiEvents.LanguajeSelected -> {
                uiState.value = uiState.value.copy(
                    languajeSelected = events.languajeValue
                )
                Log.d(TAG, "onEvent:LanguageEntered ->> ")
                Log.d(TAG, "${uiState.value} ")
            }
        }
    }
    /**
     * Función que verifica si el estado actual es válido.
     *
     * @return true si todos los campos necesarios están llenos, false de lo contrario.
     */
    fun isValidState(): Boolean {
        val allFieldsFilled =
            uiState.value.nameEntered.isNullOrEmpty().not() && uiState.value.languajeSelected.isNullOrEmpty().not()
        if (allFieldsFilled) {
            return true
        } else {
            return false
        }
    }
}



