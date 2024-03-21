package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.screens.FunFactsNavigationGraph
import com.example.jetpackcompose.ui.screens.Routes
import com.example.jetpackcompose.ui.screens.UserInputScreen
import com.example.jetpackcompose.ui.screens.WelcomeScreen
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

/**
 * MainActivity es el punto de entrada de la aplicación. Configura el entorno de Jetpack Compose
 * e inicializa el gráfico de navegación.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece el contenido de la vista con JetPackComposeTheme envolviendo la función componible principal.
        setContent {
            JetPackComposeTheme {
                FunFactApp() // Invoca la función componible principal.
            }
        }
    }

    /**
     * Función componible principal para la aplicación.
     */
    @Preview
    @Composable
    private fun FunFactApp() {
        // Punto de entrada al gráfico de navegación.
        FunFactsNavigationGraph()
    }
}
