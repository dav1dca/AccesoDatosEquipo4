package uem.es;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class EmployeeManager {

	static final String FICHERO_PRUEBAS = "./resources/empleados-prueba.dat";
	static final String FICHERO = "./resources/empleados.dat";

	public void crearFicheroPruebas() {
		ArrayList<Employee> listaEmplea = new ArrayList<Employee>();
		Employee emp = new Employee(1, "fernández", "josé", 1, "12/11/2014",
				1000, 0f, 1);
		listaEmplea.add(emp);
		emp = new Employee(2, "Perez", "Juan", 2, "15/12/2014", 1200, 1, 2);
		listaEmplea.add(emp);
		emp = new Employee(2, "Gonzalez", "Maria", 2, "15/12/2014", 3000, 100,
				1);
		listaEmplea.add(emp);
		ObjectOutputStream streamOut = null;
		try {
			streamOut = new ObjectOutputStream(new FileOutputStream(
					FICHERO_PRUEBAS));
		
			
			for(Employee e: listaEmplea)
				streamOut.writeObject(e);

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error IO" + e.getMessage());

		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error IO" + e.getMessage());

				}
		}

	}
}
