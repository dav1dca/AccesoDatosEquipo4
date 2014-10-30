package uem.es;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Department {
	public void CrearFichero(String ruta) {
		File fichero = new File(ruta);
		try {
			//Escritura
			java.io.BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivos/Departamentos.txt"));
			bufferedWriter.append("Esto es la linea 1");
			bufferedWriter.flush();
			bufferedWriter.newLine();
			bufferedWriter.append("Esto es la linea 2");
			bufferedWriter.flush();
 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
