package com.iessanalberto.dam2.tareasapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
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
            modifier: Modifier = Modifier,
            onClick: () -> Unit
) {
    // Tipicia tarjeta
    ElevatedCard (
        // Aqui van parametros de edición
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.MyColor)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),


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
        Text(text = "Estado: ${tarea.estado.etiqueta}", // Revisar
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center)
    }
}