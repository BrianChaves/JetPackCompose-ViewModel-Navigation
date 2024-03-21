package com.example.jetpackcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.ui.UserInputViewModel


/**
 * Composable que define el gráfico de navegación de la aplicación.
 * Configura las rutas y los composables asociados para la navegación entre pantallas.
 *
 * @param userInputViewModel ViewModel utilizado para la pantalla de entrada de usuario.
 */

@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {

    // NavController que gestiona la navegación entre las distintas pantallas.
    val navController = rememberNavController()

    // Configura el gráfico de navegación con las rutas y los composables asociados.
    NavHost(navController = navController, startDestination = Routes.User_Input_Screen) {
        // Pantalla de entrada de usuario.

        composable(Routes.User_Input_Screen) {
            UserInputScreen(userInputViewModel, showWelcomeScreen = {
                println("Coming_inside_showWelcomeScreen")
                println(it.first)
                println(it.second)
                navController.navigate(Routes.Welcome_Screen + "/${it.first}/${it.second}")
            }
            )
        }

        composable("${Routes.Welcome_Screen}/{${Routes.USER_NAME}}/{${Routes.LANGUAJE_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.LANGUAJE_SELECTED) { type = NavType.StringType }
            )
        ) {
            // Obtiene los argumentos de la URL para mostrar el nombre de usuario y el idioma seleccionado.
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val languajeSelected = it?.arguments?.getString(Routes.LANGUAJE_SELECTED)

            WelcomeScreen(username, languajeSelected)
        }
    }
}