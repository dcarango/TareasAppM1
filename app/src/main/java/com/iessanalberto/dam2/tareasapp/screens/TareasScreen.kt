package com.iessanalberto.dam2.tareasapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.R
import com.iessanalberto.dam2.tareasapp.components.MyCard
import com.iessanalberto.dam2.tareasapp.data.listaTareas
import com.iessanalberto.dam2.tareasapp.navigation.AppScreens

/**
 * Usualmente va siempre con el Scaffold si quiero añadirle más cosas
 */

@Composable
fun TareasScreen (navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton( onClick = {navController.navigate(AppScreens.NewTareaScreen.route)}) {
                Icon(imageVector = Icons.Filled.AddCircle , contentDescription = "Nueva tarea")
            }
        }
    ) {
        paddingValues -> TareasBodyContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            navController = navController
        )
    }
}

/**
 *LazyColum es el scroll infinito, se le pasa la lista de cosas que quieres que recorra
 */
@Composable
fun TareasBodyContent (modifier: Modifier, navController: NavController) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // Recorrer la lista para mostrar ListaTareas
        items(listaTareas) {
            tarea ->
            MyCard(tarea = tarea,
                // Aqui monta la tarea ya con el id
                // El id se pasa al nav
                onClick = {navController.navigate(route = AppScreens.EditDeleteTaskScreen.route + "/${tarea.id}")}
                )
        }
    }
}
