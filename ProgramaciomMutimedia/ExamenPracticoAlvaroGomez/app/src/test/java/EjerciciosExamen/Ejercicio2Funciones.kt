package EjerciciosExamen

fun main() {
    var opcion: Int

    // Creamos el menú que no se pueda salir hasta darle a la opción 2
    do {
        println("Bienvenido al juego Piedra, Papel o Tijeras:")
        println("1. Jugar")
        println("2. Salir")
        print("Ingrese su opción: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> jugarPartidas()
            2 -> println("¡Nos vemo maquina!")
            else -> println("Opción no válida. Solo valores 1 o 2.")
        }
    } while (opcion != 2)
}

fun jugarPartidas() {
    // Solicitar al usuario el número de partidas a jugar
    println("Ingrese el número de partidas que desea jugar:")
    val numeroDePartidas = readLine()?.toIntOrNull() ?: 0

    var partidasGanadasUsuario = 0
    var partidasGanadasChikote = 0

    for (i in 1..numeroDePartidas) {
        println("--- Partida $i ---")

        // Elección del usuario
        val eleccionUsuario = pedirEleccionUsuario()

        // Jugada que se genera aleatoriamente de Chikote
        val eleccionesPosibles = listOf("piedra", "papel", "tijeras")
        val eleccionChikote = eleccionesPosibles.random()
        println("Chikote eligió: $eleccionChikote")

        // Recibimos el ganador de la partida
        val resultadoPartida = determinarGanador(eleccionUsuario, eleccionChikote)

        // Mostrar el resultado de la partida
        println("Resultado de la partida: $resultadoPartida")

        // Actualizamos el marcador de resultados
        when (resultadoPartida) {
            "Usuario" -> partidasGanadasUsuario++
            "Máquina" -> partidasGanadasChikote++
        }
    }
    // Enseñamos el resultado final
    println("\nResultado Final:")
    println("--- Partidas ganadas por el Usuario: $partidasGanadasUsuario ---")
    println("--- Partidas ganadas por la Máquina: $partidasGanadasChikote ---")
}

// Pedimos la elección al usuario
fun pedirEleccionUsuario(): String {
    var eleccionUsuario: String
    do {
        println("-Elige (1. Piedra, 2. Papel, 3. Tijeras):")
        eleccionUsuario = when (readLine()?.toIntOrNull() ?: 0) {
            1 -> "piedra"
            2 -> "papel"
            3 -> "tijeras"
            else -> ""
        }
    } while (eleccionUsuario.isEmpty())
    return eleccionUsuario
}

// De cada partida en esta función sacamos al ganador según las elecciones
fun determinarGanador(eleccionUsuario: String, eleccionChikote: String): String {
    return when {
        eleccionUsuario == eleccionChikote -> "Empate"
        (eleccionUsuario == "piedra" && eleccionChikote == "tijeras") ||
                (eleccionUsuario == "papel" && eleccionChikote == "piedra") ||
                (eleccionUsuario == "tijeras" && eleccionChikote == "papel") -> "Usuario"

        else -> "Máquina"
    }
}