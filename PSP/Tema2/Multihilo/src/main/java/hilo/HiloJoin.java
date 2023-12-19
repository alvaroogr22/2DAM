package hilo;

class Arriba extends Thread{
	
	boolean stopHilo=false;
	
	public void pararHilo() {
		stopHilo=true;
	}
	
	public void run() {
		while (!stopHilo) {
	         System.out.println("El hilo "+getName()+" se está ejecutando.");
		}
		System.out.println("Fin de "+getName());
	}
}

class Abajo extends Thread{
	public void run() {
		for (int i = 100; i >=0; i--) {
			System.out.println(getName()+" cuenta "+i);
		}
		System.out.println("Fin de "+getName());
	}
}



public class HiloJoin {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arriba h1=new Arriba();
		Abajo h2=new Abajo();
		
		h1.setName("Hilo 1");
		h2.setName("Hilo 2");
		
		h1.setPriority(1);
		h2.setPriority(Thread.MAX_PRIORITY);
		
		imprimirEstado(h1, h2);
		
		h1.start();
		h2.start();
		
		try {
			h1.sleep(5);
			h2.join();		
		} catch (InterruptedException e) {
			
		}
		h1.pararHilo();
		System.out.println("La funcion pararHilo ha funcionado.");
		System.out.println("\nEl programa ha finalizado.");
		System.out.println();
		imprimirEstado(h1, h2);
	}
	
	public static void imprimirEstado(Thread h1, Thread h2) {
		System.out.println("El hilo 1 se encuentra en estado " + h1.getState());
		System.out.println("El hilo 2 se encuentra en estado " + h2.getState());


	}

}
