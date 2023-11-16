package ejecuciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListarProcesos {

	public static void main(String[] args) {
		listarProcesosWindows();
	}

	private static void listarProcesosWindows() {
		try {
			Process process = Runtime.getRuntime().exec("tasklist");
			BufferedReader reader = new BufferedReader(
					new BufferedReader(new InputStreamReader(process.getInputStream())));
			System.out.println("Procesos en ejecución:");
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}