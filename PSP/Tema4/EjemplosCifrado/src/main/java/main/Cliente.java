package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cliente {

	public static void main(String[] args) {
        // Crear instancia del cliente
        Cliente cliente = new Cliente();
        System.out.println("ESTA ES LA CLASE CLIENTE");
        // Mensaje a enviar al servidor
        String mensaje = "El cuco está en el nido.";

        // Enviar el mensaje al servidor
        cliente.enviarMensajeAlServidor(mensaje);
    }

    // Método para enviar el mensaje al servidor
    public void enviarMensajeAlServidor(String mensaje) {
        // Encriptar el mensaje a hexadecimal con SHA-256
        String mensajeEncriptado = encriptarSHA256(mensaje);
        System.out.println("Mensaje encriptado: " + mensajeEncriptado);

        // Crear instancia del servidor y enviar el mensaje encriptado
        Servidor servidor = new Servidor();
        servidor.recibirMensajeDelCliente(mensajeEncriptado);
    }

    // Método para encriptar un mensaje a hexadecimal con SHA-256
    public String encriptarSHA256(String mensaje) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(mensaje.getBytes());

            // Convertir bytes a hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}