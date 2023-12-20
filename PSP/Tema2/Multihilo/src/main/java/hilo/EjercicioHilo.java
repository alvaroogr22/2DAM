package hilo;

class Par extends Thread {
	public void run() {
		for (int i = 0; i <= 20; i = i + 2) {
			System.out.println(getName() + " cuenta " + i);
		}
		System.out.println("\nFin del " + getName());
	}
}

class Impar extends Thread {
	public void run() {
		for (int i = 1; i <= 20; i = i + 2) {
			System.out.println(getName() + " cuenta " + i);
		}
		System.out.println("\nFin del " + getName());
	}
}

public class EjercicioHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Par h1 = new Par();
		Impar h2 = new Impar();

		h1.setName("Hilo 1");
		h2.setName("Hilo 2");
		h1.setPriority(10);
		h2.setPriority(1);

		h1.start();
		h2.start();

		System.out.println("Hey");

	}

}
