package EjerciciosExamen

fun main() {
    // Creamos la matriz con los nombres de los empleados y su sueldo
    val matrizEmpleados = arrayOf(
        arrayOf("Chikito", "Eva", "Ana", "Pedro"),
        arrayOf(1700.0, 2800.0, 1900.0, 2300.0)
    )

    // Mostramos nombre extraidos de la matriz
    val nombresEmpleados = matrizEmpleados[0].joinToString(", ")
    println("Nombres de los empleados: $nombresEmpleados")

    // Se calcula la media de los salarios
    val salariosBase = matrizEmpleados[1].map { it as Double }
    val salariosFormateados = salariosBase.joinToString(", ")
    val notaMedia = salariosBase.average()
    val sumaTotal = salariosBase.sum()

    println("Salarios base de los empleados: $salariosFormateados")
    println("Nota media de los salarios base: $notaMedia €")
    println("Suma total de los salarios base: $sumaTotal €")
}