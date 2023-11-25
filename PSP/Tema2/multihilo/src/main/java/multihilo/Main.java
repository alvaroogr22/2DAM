package multihilo;

public class Main {

	public static void main(String[] args) {
		// Crear los hilos
        Thread hiloPares = new Thread(new ImprimirPares());
        Thread hiloImpares = new Thread(new ImprimirImpares());

        // Iniciar los hilos
        hiloPares.start();
        hiloImpares.start();

        // Esperar a que ambos hilos terminen
        try {
            hiloPares.join();
            hiloImpares.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado.");
    }
}

// Clase que implementa la impresión de números pares
class ImprimirPares implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Número par: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Clase que implementa la impresión de números impares
class ImprimirImpares implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 19; i += 2) {
            System.out.println("Número impar: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}
