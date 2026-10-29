package com.iessanalberto.dam2.tareasapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.iessanalberto.dam2.tareasapp.models.Estado
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
    var isPendienteChecked by remember { mutableStateOf(false) }
    var isEnProgresoChecked by remember { mutableStateOf(false) }
    var isCompletadoChecked by remember { mutableStateOf(false) }

    // variable que guarda el filtro para luego poder saber si esta vacio o no
    var listaFiltrada = listaTareas.filter {
                it.estado == Estado.PENDIENTE && isPendienteChecked ||
                it.estado == Estado.EN_PROGRESO && isEnProgresoChecked ||
                it.estado == Estado.COMPLETADO && isCompletadoChecked
    }

    // Contenedor para elementos de filtrado
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Elementos de filtrado
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isPendienteChecked,
                onCheckedChange = {isPendienteChecked = it}
            )
            Text(text = Estado.PENDIENTE.etiqueta)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isEnProgresoChecked,
                onCheckedChange = {isEnProgresoChecked = it}
            )
            Text(text = Estado.EN_PROGRESO.etiqueta)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCompletadoChecked,
                onCheckedChange = {isCompletadoChecked = it}
            )
            Text(text = Estado.COMPLETADO.etiqueta)
        }

        // Si la lista está vacia mostrará el mensaje, si no, pasará el lazy
        if (listaFiltrada.isEmpty()) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "No hay nada que mostrar")
        } else {
            LazyColumn(
                modifier = modifier.fillMaxWidth(), // Ojo que aqui es Width y no Max porque si no se sobre pone
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Recorrer la lista para mostrar ListaTareas
                items(listaFiltrada) { tarea ->
                    MyCard(tarea = tarea,
                        // Aqui monta la tarea ya con el id
                        // El id se pasa al nav
                        onClick = {navController.navigate(route = AppScreens.EditDeleteTaskScreen.route + "/${tarea.id}")}
                    )
                }
            }
        }
    }
}

