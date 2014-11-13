package uem.es;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;


public class EmployeeManager {

	static final String FICHERO_PRUEBAS = "./src/resources/empleados-prueba.dat";
	static final String FICHERO = "./src/resources/empleados.dat";
	ArrayList<Employee> listaEmplea = new ArrayList<Employee>();
	Employee emp = new Employee();
	public void crearFicheroPruebas() {
		
		int id ;
	     String lastname;
		 String name;
		 int job;
		 Date regisDate;
		 int salary;
		 float commission;
		 int depNumber;
		 SimpleDateFormat format;
		 String DATE_FORMAT = "dd/MM/yyyy";
		 String salir;
		 // scaner salir
		 Scanner sal = new Scanner(System.in);
		 // scaner de las partes del empleado.
		 Scanner sID = new Scanner(System.in);
		 Scanner sLast = new Scanner(System.in);
		 Scanner sName = new Scanner(System.in);
		 Scanner sJob = new Scanner(System.in);
		 Scanner sRegiD = new Scanner(System.in);
		 Scanner sSala = new Scanner(System.in);
		 Scanner sCom = new Scanner(System.in);
		 Scanner sDep = new Scanner(System.in);
		 
		 
		 do{
		 System.out.println("Ve estribiendo el contenido del empleado");
		 System.out.println("Id del Empleado: ");
		 id = sID.nextInt();
		 System.out.println("Apellido del Empleado: ");
		 lastname = sLast.nextLine();
		 System.out.println("Nombre del Empleado");
		 name = sName.nextLine();
		 System.out.println("Introduce el trabajo");
		 job = sJob.nextInt();
		 System.out.println("Fecha de registro dd/MM/yyyy");
		 
		 System.out.println("Introduce el salario");
		 salary = sSala.nextInt();
		 System.out.println("Introduce la comision");
		 commission = sCom.nextFloat();
		 System.out.println("Introduce el departamento");
		 depNumber = sDep.nextInt();
		 System.out.println("Si quieres salir escribe 'fin' de lo contrario pulsa intro");
		 salir = sal.next();
		 
		emp = new Employee(id,lastname,name,job,"15/12/2014",salary,commission,depNumber);
		listaEmplea.add(emp);
		 }while(salir == "n");
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
	
	public void imprimirFicheroEmployee(String path) {
		ObjectInputStream streamIn = null;
		Employee emp;
		
		try {
			streamIn = new ObjectInputStream (new FileInputStream (path));
			
			try{
			while(true){
				emp = (Employee) streamIn.readObject();
				System.out.println(emp);
			}
			}catch (EOFException e) {
			
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Error IO" + e.getMessage());

		} catch (ClassNotFoundException e) {
			System.err.println("Class not found: " + e.getMessage());

		}finally{
			if(streamIn != null){
				try {
					streamIn.close();
				} catch (IOException e) {
					System.err.println("Error IO" + e.getMessage());

				}
			}
		}
	
		
	
		 
	}
	
}
