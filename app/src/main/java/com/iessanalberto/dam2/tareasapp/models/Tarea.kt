package com.iessanalberto.dam2.tareasapp.models

/**
 *Tipica clase
 */
data class Tarea(
    var id: Int = siguienteId(),
    var nombre: String,
    var responsable : String,
    var descripcion: String,
    var estado: Estado = Estado.PENDIENTE
) {
    // Esto es el equivalente al static
    companion object{
        var contador = 0
        fun siguienteId():Int = ++contador

        // fun siguienteId():Int {
        //  retrun contador++
        //  }
    }

}

enum class Estado (val etiqueta: String) {
    PENDIENTE (etiqueta = "Pendiente") ,
    EN_PROGRESO (etiqueta = "En progreso"),
    COMPLETADO (etiqueta = "Completado")
}