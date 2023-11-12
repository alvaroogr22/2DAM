package Hilo;

public class Principal extends Thread {

	private int id;

	public Principal(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Soy el hilo: " + id);
	}

	public static void main(String[] args) {
		// Se crean los hilos
		Principal h1 = new Principal(1);
		Principal h2 = new Principal(2);
		Principal h3 = new Principal(3);

		// Se ejecutan
		h1.start();
		h2.start();
		h3.start();

		System.out.println("Soy el hilo principal");
	}

}
