    package com.iessanalberto.dam2.tareasapp.data

import com.iessanalberto.dam2.tareasapp.models.Tarea

/*
*Aqui van datos que nos interesa no derepetir
 */

/*
 Hay dos tipos de de listas
 Mutable y list, Mutable nos deja añadir y eliminar, List no.

 Forma de llamar:
 val listaTareas: List<Tarea> = listOf("Dormir, comer, bañarse")

*/
val listaTareas: MutableList<Tarea> = mutableListOf(
    Tarea(
        nombre = "Dormir",
        responsable = "Dani",
        descripcion = "Dormir un rato"
    ),
    Tarea(
        nombre = "Limpiar la caja de arena",
        responsable = "Dani",
        descripcion = "Ya huele"
    ),
    Tarea(
        nombre = "Comprar platanos",
        responsable = "Dani",
        descripcion = "Se están acabando"
    ),
    Tarea(
        nombre = "Hacer de comer",
        responsable = "Dani",
        descripcion = "Que hambre"
    ),
)

fun buscarTarea (id: Int?): Tarea? {
    var task: Tarea? = null

    for (tarea in listaTareas) {
        if (tarea.id == id) {
            task = tarea
        }
    }
    return task
}