package hilo;

public class HiloDead extends Thread {

	boolean stopHilo = false;
	
	   public void pararHilo() {
	      stopHilo = true;
	   }
	   public void run() {
	      while (!stopHilo) {
	         System.out.println("El hilo se está ejecutando.");
	      }
	   }
	   public static void main(String[] args) {
	      HiloDead h = new HiloDead();
	      h.start();
	      try {
	         Thread.sleep(1000);
	      } catch (InterruptedException e) {
	      e.printStackTrace();
	      }
	      h.pararHilo();
	      System.out.println("El hilo ha parado");
	   }
	}
