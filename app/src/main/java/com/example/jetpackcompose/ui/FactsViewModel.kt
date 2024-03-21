package com.example.jetpackcompose.ui

import androidx.lifecycle.ViewModel
/**
 * ViewModel utilizado para proporcionar datos aleatorios sobre lenguajes de programación.
 */
class FactsViewModel : ViewModel() {

    /**
     * Genera un hecho aleatorio sobre el lenguaje de programación seleccionado.
     *
     * @param selecteLanguage El lenguaje de programación seleccionado.
     * @return Un hecho aleatorio sobre el lenguaje de programación seleccionado.
     */
    fun generateRandomFacts(selecteLanguage: String): String {
        return when (selecteLanguage) {
            "Kotlin" -> getKotlinFacts().random()
            "Dart" -> getDartFacts().random()
            "Swift" -> getSwiftFacts().random()
            else -> "Lenguaje no válido"
        }
    }


    fun getKotlinFacts(): List<String> {
        val kotlinFacts = listOf(
            "Desarrollado por JetBrains.",
            "Oficial para Android desde 2017.",
            "Interoperable con Java.",
            "Nulabilidad segura, funciones de orden superior y extensiones de funciones."
        )
        return kotlinFacts
    }

    fun getSwiftFacts(): List<String> {
        val swiftFacts = listOf(
            "Desarrollado por Apple en 2014.",
            "Sucesor de Objective-C.",
            "Inferencia de tipos, nulabilidad segura y manejo de errores.",
            "Interoperable con Objective-C."
        )
        return swiftFacts
    }

    fun getDartFacts(): List<String> {
        val dartFacts = listOf(
            "Desarrollado por Google.",
            "Se usa con Flutter para desarrollo móvil.",
            "Tipado estático opcional, recolección de basura.",
            "Asincronismo basado en futures y streams.",
            "Compila a código nativo para varias plataformas."
        )
        return dartFacts
    }


}