package com.iessanalberto.dam2.tareasapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.iessanalberto.dam2.tareasapp.R
import com.iessanalberto.dam2.tareasapp.models.Tarea

/**
 * Sitio donde guardamos componentes por su carga, le pasamos los parametros necesarios
 */
@Composable
fun MyCard (tarea: Tarea,
            onClick: () -> Unit
) {
    // Tipicia tarjeta
    ElevatedCard (
        // Aqui van parametros de edición
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.MyColor)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.size(width = 240.dp, height = 400.dp).padding(15.dp),

        // Lo que pasa cuando haces click
        // Se la pasamos por parametro
        onClick = onClick
    ) {
        // Text de la listaTareas
        Text(text = "Tarea: ${tarea.nombre}",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center)
        Text(text = "responsable: ${tarea.responsable}",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center)
        Text(text = "Descripción: ${tarea.descripcion}",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center)
        Text(text = "Estado: ${tarea.estado}",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center)
        Image(
            painter =  painterResource(R.drawable.ottoniel),
            contentDescription = "El baboso de mi gato"
        )

    }
}