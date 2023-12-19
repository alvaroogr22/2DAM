package ficherostexto;
// no es necesario usar br.close, se encarga solo java
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3ComprobarFichero {
    public static void main(String[] args) {
    	
    	String[] ciudades = {"Malaga.txt", "Cordoba.txt","Cadiz.txt"};
    	
    	for (String ciudad : ciudades) {
    	    try (BufferedReader br = new BufferedReader(new FileReader("c:\\prueba1\\" + ciudad))) {
    	        String linea;
    	        while ((linea = br.readLine()) != null) {
    	            System.out.println("Fichero " + ciudad + " localizado");
    	          
    	        }
    	    } catch (FileNotFoundException fnfe) {
    	        System.out.println("No se encuentra el fichero " + ciudad);
    	    } catch (IOException ioe) {
    	        System.out.println("No se puede leer el fichero " + ciudad);
    	    }
    	 
    	}
      }
    
}
