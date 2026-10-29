package com.iessanalberto.dam2.tareasapp.screens

import android.content.Context
import androidx.compose.material3.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.data.buscarTarea
import com.iessanalberto.dam2.tareasapp.data.listaTareas
import com.iessanalberto.dam2.tareasapp.models.Tarea

@Composable
fun EditDeleteTaskScreen(navController: NavController, id: Int) {
    // Nos traemos la tarea aqui arriba
    val context = LocalContext.current
    val tarea = buscarTarea(id = id)
    // Esto es para el AlertDialog
    var showDialog by remember { mutableStateOf(false) }

    if (tarea == null) {
        Toast.makeText(context,"Algo fue mal", Toast.LENGTH_SHORT).show()
        navController.popBackStack()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // Botones de abajo para guardar o borrar
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                // Siempre va esto
                actions = {},
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            showDialog = true


                        },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    )
                     {
                        Icon(imageVector = Icons.Filled.Delete,
                            contentDescription = "Borrar tarea")
                    }
                }
            )
        }


        ) { innerPadding ->
        EditDeleteBodyContent(modifier = Modifier.padding(innerPadding),
            navController = navController,
            // Pasamos la tarea, reclamaba porque pensaba que no iba a llegar, pero con "!!" le decimos tu tranquilo yo nervioso
            tarea = tarea!!,
            context = context) }

    // AlertDialog (Hay que manejarlo con una bandera)

    if (showDialog) {
        AlertDialog(
            icon = {Icon(imageVector = Icons.Filled.Delete,
                contentDescription = "Confirmar borrado")},
            title = {Text(text = "Confirmar borrado")},
            text = {Text(text = "¿Estás seguro? ${tarea!!.nombre}?")},
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        // Aqui borra la tarea
                        listaTareas.remove(tarea)
                        Toast.makeText(context,"Tarea eliminada", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                    }
                ) {
                    Text(text = "Confirmar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        // Aqui cancelar
                        showDialog = false
                    }
                ) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}

@Composable
fun EditDeleteBodyContent(
    modifier: Modifier,
    navController: NavController,
    tarea: Tarea,
    context: Context, ) {

    var nombre by remember { mutableStateOf(tarea.nombre) }
    var responsable by remember { mutableStateOf(tarea.responsable) }
    var descripcion by remember { mutableStateOf(tarea.descripcion) }
    var estado by remember { mutableStateOf(tarea.estado) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // Campos para editar
        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre= it},
            label = {Text(text = "Nombre")}
        )
        OutlinedTextField(
            value = responsable,
            onValueChange = {responsable= it},
            label = {Text(text = "Responsable")}
        )
        OutlinedTextField(
            value = descripcion,
            onValueChange = {descripcion= it},
            label = {Text(text = "Descripcion")}
        )
        OutlinedTextField(
            value = estado,
            onValueChange = {estado= it},
            label = {Text(text = "estado")}
        )
        Button(onClick = {
            tarea.nombre = nombre
            tarea.responsable = responsable
            tarea.descripcion = descripcion
            tarea.estado = estado

            Toast.makeText(context,"Tarea actualizada", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
        }) {
            Text(text = "Guardar")
        }
    }
}