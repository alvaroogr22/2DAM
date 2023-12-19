package ficherostexto;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Ejercicio5FicheroBinario {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String usuario, clave;

        // Escribir objetos en el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:\\prueba1\\config.txt"))) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese el nombre de usuario: ");
            usuario = br.readLine();
            System.out.print("Ingrese la clave: ");
            clave = br.readLine();
            oos.writeObject(usuario);
            oos.writeObject(clave);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            return;
        }

        // Leer objetos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:\\prueba1\\config.txt"))) {
            usuario = (String) ois.readObject();
            clave = (String) ois.readObject();
        } catch (IOException e) {
            System.err.println("Error al leer del archivo: " + e.getMessage());
            return;
        }

        System.out.println("Nombre de usuario: " + usuario);
        System.out.println("Clave: " + clave);
    }
}
