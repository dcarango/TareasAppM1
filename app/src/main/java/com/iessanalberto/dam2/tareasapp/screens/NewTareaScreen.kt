    package com.iessanalberto.dam2.tareasapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.data.listaTareas
import com.iessanalberto.dam2.tareasapp.models.Estado
import com.iessanalberto.dam2.tareasapp.models.Tarea

@Composable
fun NewTareaScreen (navController: NavController) {
    Scaffold() {
        innerpadding -> NewTareaBodyContent(navController = navController, modifier = Modifier.padding(innerpadding))
    }
}

@Composable
fun NewTareaBodyContent (navController: NavController, modifier: Modifier) {
    var nombre by remember { mutableStateOf("") }
    var responsable by remember { mutableStateOf("Pendiente de asignación") }
    var descripcion by remember { mutableStateOf("") }
    var estadoSeleccionado by remember { mutableStateOf(Estado.PENDIENTE) }
    var context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text(text = "Nombre") }
        )
        OutlinedTextField(
            value = responsable,
            onValueChange = {responsable = it},
            label = { Text(text = "Responsable") }
        )
        OutlinedTextField(
            value = descripcion,
            onValueChange = {descripcion = it},
            label = { Text(text = "Descripción") }
        )

        // Cambiado por Enum
        // importante, el .entries para poder usar el .forEach
        Estado.entries.forEach { estado ->
            // Una fila por cada valor del enum
            Row(
                modifier = Modifier.fillMaxWidth()
                    .selectable(
                        selected = (estado == estadoSeleccionado),
                        onClick = { estadoSeleccionado= estado },
                        role = Role.RadioButton // Se le dice que se comporte como un radio button, se puede cambiar por checkBox
                    )
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = (estado == estadoSeleccionado),
                    onClick = null
                )
                Text(text = estado.etiqueta, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Button(onClick = {
            if (nombre.isBlank() || responsable.isBlank() || descripcion.isBlank()){
                Toast.makeText(context,"Los campos debes estar llenos",Toast.LENGTH_LONG).show()
            } else {
            listaTareas.add(Tarea(
                // ejemplo de validacion
                nombre = nombre,
                responsable = responsable,
                descripcion = descripcion,
                estado = estadoSeleccionado
            ))
            Toast.makeText(context,"Tarea añadida con exito",Toast.LENGTH_LONG).show()
            navController.popBackStack() // Para volver atrás
            }

        }) {
            Text(text = "Guardar")
        }
    }
}