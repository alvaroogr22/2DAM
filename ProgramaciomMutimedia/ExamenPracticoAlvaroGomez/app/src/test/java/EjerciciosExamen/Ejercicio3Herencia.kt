package EjerciciosExamen

// Clase general de los deportes
open class Deporte(val nombre: String, val tipoTerreno: String) {
    open fun mostrarDetalles() {
        println("Deporte: $nombre")
        println("Tipo de terreno: $tipoTerreno")
    }
}

//Clase futbol para insertar sus datos
class Futbol(
    nombre: String,
    tipoTerreno: String,
    val numeroJugadores: Int,
    val esCampoGrande: Boolean
) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Número de jugadores: $numeroJugadores")
        println("Campo grande: $esCampoGrande")
    }
}

//Clase Baloncesto para insertar sus datos
class Baloncesto(
    nombre: String,
    tipoTerreno: String,
    val alturaCanasta: Double,
    val esDeporteEquipo: Boolean
) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Altura de la canasta: $alturaCanasta metros")
        println("Deporte de equipo: $esDeporteEquipo")
    }
}

//Clase Balonmano para insertar sus datos
class Balonmano(
    nombre: String,
    tipoTerreno: String,
    val esDeporteOlimpico: Boolean,
    val esContacto: Boolean
) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Deporte olímpico: $esDeporteOlimpico")
        println("Deporte de contacto: $esContacto")
    }
}

//Clase voleibol para insertar sus datos
class Voleibol(
    nombre: String,
    tipoTerreno: String,
    val esDeportePlaya: Boolean,
    val numeroJugadoresEquipo: Int
) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Deporte de playa: $esDeportePlaya")
        println("Número de jugadores por equipo: $numeroJugadoresEquipo")
    }
}

//En el main creamos todas las variables de los deportes
//y hacemos que imprima usando las clases anteriormente creadas
fun main() {
    val futbol = Futbol("Fútbol", "Campo", 11, true)
    val baloncesto = Baloncesto("Baloncesto", "Pista", 3.05, true)
    val balonmano = Balonmano("Balonmano", "Campo", true, true)
    val voleibol = Voleibol("Vóley", "Arena", true, 6)

//Imprimimos
    futbol.mostrarDetalles()
    println("\n-----------------\n")
    baloncesto.mostrarDetalles()
    println("\n-----------------\n")
    balonmano.mostrarDetalles()
    println("\n-----------------\n")
    voleibol.mostrarDetalles()
}