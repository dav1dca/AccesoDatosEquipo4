package uem.es;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Department {
	public void CrearFichero(String ruta) {
		Scanner scan = new Scanner(System.in);
		String usuario;
		int usuarios;
		File fichero = new File(ruta);
		usuario = scan.nextLine();
		
		try {
			System.out.println("Introduce al usuario, para finalizar introduce fin");
			System.out.println("id, lastname (20) name (20), job, regis_date, salary, commission, depNumber");
			java.io.BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../Actividad06/src/fichero.txt"));
			
			//Escritura
			
			bufferedWriter.append("id, lastname (20) name (20), job, regis_date, salary, commission, depNumber");
			bufferedWriter.flush();
			while(usuario==usuario){
			bufferedWriter.newLine();
			bufferedWriter.append(usuario);
			bufferedWriter.flush();
			
			}
 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
