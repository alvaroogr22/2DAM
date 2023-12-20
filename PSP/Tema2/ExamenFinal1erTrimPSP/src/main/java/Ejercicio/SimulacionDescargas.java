package Ejercicio;

// Definición de la clase implementada por Runnable
/*1. Crea un programa que ejecute tres hilossimulando una descarga que llega al 100% con 
la interfaz Runnable. 1 punto (0,5 si lo haces extendiendo la clase Thread) */
public class SimulacionDescargas implements Runnable {
    private String nombre;
    private int incremento;

    // Constructor del nombre y el incremento
    public SimulacionDescargas(String nombre, int incremento) {
        this.nombre = nombre;
        this.incremento = incremento;
    }

    // El metodo run se inicia cuando empiece a ejecutarse un hilo
    @Override
    public void run() {
        /*
         * 4. El hilo 3 tendrá la máxima prioridad, el hilo 2 tendrá la mínima prioridad
         * y el hilo 1
         * tendrá una prioridad normal. 1 punto
         */
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        if (nombre.equals("descarga 3")) {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        } else if (nombre.equals("descarga 2")) {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        }

        /*
         * 3. El hilo 1 avanzará con su contador de 1 en 1; el hilo 2 avanzará con su
         * contador de 2 en 2; el hilo 3 avanzará de 3 en 3. Los hilos finalizarán al
         * llegar al 100% y mostrarán el mensaje “La (descarga que haya finalizado) se
         * ha completado”. Pon un sleep(100) para que el contador no avance tan rápido.
         * 1 punto
         */
        for (int i = 1; i <= 100; i++) {
            System.out.println(nombre + ": " + i + "%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i += incremento - 1;
        }

        System.out.println("La " + nombre + " se ha completado");
    }

    public static void main(String[] args) { // Empieza la ejecución del programa
        /*
         * 2. Los hilos tendrán los nombres “descarga 1” “descarga 2” y “descarga 3”. 1
         * punto.
         */
        Thread hilo1 = new Thread(new SimulacionDescargas("descarga 1", 1));
        Thread hilo2 = new Thread(new SimulacionDescargas("descarga 2", 2));
        Thread hilo3 = new Thread(new SimulacionDescargas("descarga 3", 3));

        hilo1.start();
        hilo2.start();
        hilo3.start();
        /*
         * 5. Cuando termine la ejecución de los tres hilos aparecerá el mensaje “Las
         * descargas han finalizado”. No utilices el método sleep. 2 puntos
         */
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Las descargas han finalizado");
    }
}
