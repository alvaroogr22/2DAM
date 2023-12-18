package EjerciciosExamen

fun mostrar(lista: List<Any>) {
    println("Contenido de la lista:")
    //Creamos el bucle que mientras hay elementos en la lista se sigue ejecutando hasta terminar, lo usamos para imprimir los datos
    for (i in 0 until lista.size step 3) {
        val asignatura = lista[i] as String
        val estudiante = lista[i + 1] as String
        val nota = lista[i + 2] as Int

        // Evitar imprimir una línea en blanco si el estudiante está vacío
        val estudianteLinea = if (estudiante.isNotBlank()) "$estudiante\n" else ""

        println("$asignatura\n$estudianteLinea$nota")
        println()
    }
}

fun main() {
    // Crear lista mutable inicial
    val centro: MutableList<Any> = mutableListOf(
        "MATEMATICAS", "ALBERTO", 5,
        "LENGUA", "LAURA", 8,
        "HISTORIA", "PEDRO", 7
    )

    // Enseñamos la lista original
    mostrar(centro)

    // Modificamos las asignaturas
    centro[0] = "HISTORIA"
    centro[3] = "FÍSICA"

    // Mostrar lista después de la modificación
    mostrar(centro)

    // Añadimos nuevos elementos
    centro.addAll(listOf("QUÍMICA", "ANA", 7, "Cristina", "", 7))

    // Mostramos la lista otra vez después de añadir nuevos elementos
    mostrar(centro)
}