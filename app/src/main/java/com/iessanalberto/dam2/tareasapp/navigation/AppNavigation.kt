package com.iessanalberto.dam2.tareasapp.navigation

import android.R.attr.type
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iessanalberto.dam2.tareasapp.models.Tarea
import com.iessanalberto.dam2.tareasapp.screens.EditDeleteTaskScreen
import com.iessanalberto.dam2.tareasapp.screens.LogoScreen
import com.iessanalberto.dam2.tareasapp.screens.NewTareaScreen
import com.iessanalberto.dam2.tareasapp.screens.TareasScreen

/**
 * Navegacion por ventanas
 */
@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LogoScreen.route) {

        // Navegación sin argumentos
        composable (route = AppScreens.LogoScreen.route) { LogoScreen(navController) }
        composable (route = AppScreens.TareasScreen.route) { TareasScreen(navController) }
        composable (route = AppScreens.NewTareaScreen.route) { NewTareaScreen(navController) }

        // Navegacion con argumentos
        composable (route = AppScreens.EditDeleteTaskScreen.route + "/{id}",
            arguments = listOf(navArgument(name = "id") {type = NavType.IntType})
            ) {
            // Forma de decir de que la variable siempre tendrá un valor
            // o viene un numero o viene -º
            backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: -1 // OPERADOR ELVIS (Lo hacemos aqui que es donde se genera)
            EditDeleteTaskScreen(navController = navController, id = id)
        }

    }
}