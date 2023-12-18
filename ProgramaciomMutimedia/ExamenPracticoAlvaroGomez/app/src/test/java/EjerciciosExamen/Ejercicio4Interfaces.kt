package EjerciciosExamen

// Interfaces
interface Jugable { //Mete un nombre de jugador
    fun jugar(nombreUsuario: String)
}

interface SonidoAmbiente { //Crea sonidos mediambientales
    fun reproducirSonido()
}

interface GuardadoPartida { //Guardamos la partida
    fun guardarPartida()
}

// Clases Concretas
class Aventura : Jugable, SonidoAmbiente, GuardadoPartida {
    override fun jugar(nombreUsuario: String) { //Iniciamos la aventura
        println("$nombreUsuario inicia un juego de aventura.")
    }

    override fun reproducirSonido() { //Escribimos el sonido que se reproducirá
        println("Sonido de bosque en la aventura (creo que se aproxima un aberroncho salvaje).")
    }

    override fun guardarPartida() { //Guardamos partida
        println("Progreso del juego de aventura guardado.")
    }
}

class Deportes : Jugable, SonidoAmbiente, GuardadoPartida {
    //Iniciamos el juego de deporte
    override fun jugar(nombreUsuario: String) {
        println("$nombreUsuario inicia un juego de deportes.")
    }

    override fun reproducirSonido() { //Escribimos el sonido que se reproducirá
        println("Sonido de público en el juego de deportes (las gradas se enloquecen al ver a Manolo el del Bombo desatado).")
    }

    override fun guardarPartida() { //Guardamos partida
        println("Progreso del juego de deportes guardado.")
    }
}

class Estrategia : Jugable, SonidoAmbiente, GuardadoPartida { //Iniciamos el juego de estrategia
    override fun jugar(nombreUsuario: String) {
        println("$nombreUsuario inicia un juego de estrategia.")
    }

    override fun reproducirSonido() { //Escribimos el sonido que se reproducirá
        println("Sonido de batalla en el juego de estrategia (se escuchan gemidos de la gente luchando mientras Ibai castea de fondo la pelea).")
    }

    override fun guardarPartida() { //Guardamos partida
        println("Progreso del juego de estrategia guardado.")
    }
}

// En el main lo que hacemos es hahcer la impresión por pantalla de todas las clases
fun main() {
    // Demostración
    val juegoAventura = Aventura()
    val juegoDeportes = Deportes()
    val juegoEstrategia = Estrategia()

    juegoAventura.jugar("El risitas")
    juegoAventura.reproducirSonido()
    juegoAventura.guardarPartida()

    println("------------------------------------------")

    juegoDeportes.jugar("Chiquito de la calzada")
    juegoDeportes.reproducirSonido()
    juegoDeportes.guardarPartida()

    println("------------------------------------------")

    juegoEstrategia.jugar("La meretérita")
    juegoEstrategia.reproducirSonido()
    juegoEstrategia.guardarPartida()
}