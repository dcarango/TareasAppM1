package com.iessanalberto.dam2.tareasapp.navigation

/**
 * AppSrcreen, siempre va igual
 */

sealed class AppScreens (val route: String) {
    object LogoScreen: AppScreens(route="logo_screen")
    object TareasScreen: AppScreens(route="tareas_screen")
    object NewTareaScreen: AppScreens (route = "newTarea_screen")
    object EditDeleteTaskScreen: AppScreens (route = "editDelete_screen")
}