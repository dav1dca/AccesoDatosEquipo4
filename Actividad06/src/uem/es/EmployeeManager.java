package uem.es;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * @author David y Miguel
 */
public class EmployeeManager {

	public static final String pathEmp = "C:/Users/miguel/Documents/ECLIPSE Y proyectos JAVA/2ºCurso/accesoDatosGrupal/src/resources/Employee.bin";
	public static final String pathDep = "C:/Users/miguel/Documents/ECLIPSE Y proyectos JAVA/2ºCurso/accesoDatosGrupal/src/resources/Department.bin";
	private static final ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private static final ArrayList<Deparment> departamentos = new ArrayList<Deparment>();
	
	/**
	 * Constructor of Employee manager
	 */
	public EmployeeManager(){
		if(new File(pathEmp).isFile() && new File(pathDep).isFile()){
			readEmpfile();
			readDepfile();
		}else{
			System.out.println("No data, charging dummy data");
			dummy();
		}
	}
	
	/**
	 * Reads the employee .bin file
	 * @return boolean
	 */
	private boolean readEmpfile(){
		boolean result = true;
		Employee e;
		ObjectInputStream streamEntrada;
		
		try{
			streamEntrada = new ObjectInputStream(new FileInputStream(pathEmp));
			e = (Employee) streamEntrada.readObject();
			employeeList.add(e);
			while (e != null) {
				e = (Employee) streamEntrada.readObject();
				employeeList.add(e);
			}
			if (streamEntrada != null)
				streamEntrada.close();
			result = true;
		}catch(IOException | ClassNotFoundException excep){
			System.out.println("ERROR reading Empoyee: "+excep.getMessage());
			result = false;
		}
		return result;
	}
	
	/**
	 * Reads the department .bin file
	 * @return boolean
	 */
	private boolean readDepfile(){
		boolean result = true;
		Deparment dep;
		ObjectInputStream streamEntrada;
		
		try{
			streamEntrada = new ObjectInputStream(new FileInputStream(pathDep));
			dep = (Deparment) streamEntrada.readObject();
			departamentos.add(dep);
			while (dep != null) {
				dep = (Deparment) streamEntrada.readObject();
				departamentos.add(dep);
			}
			if (streamEntrada != null)
				streamEntrada.close();
			result = true;
		}catch(IOException | ClassNotFoundException excep){
			System.out.println("ERROR reading Department: "+excep.getMessage());
			result = false;
		}
		return result;
	}
	
	/**
	 * writes all the new information on the .bin files
	 */
	public void closeEmployeeManager(){
		ObjectOutputStream streamSalida = null;
		try {
			// escribimos
			streamSalida = new ObjectOutputStream(new FileOutputStream(pathEmp));
			for (Employee emp : employeeList)
				streamSalida.writeObject(emp);
			if (streamSalida != null)
				streamSalida.close();
		} catch (IOException e1) {
			System.out.println("ERROR: "+e1.getMessage());
		}
		
		try {
			// escribimos
			streamSalida = new ObjectOutputStream(new FileOutputStream(pathDep));
			for (Deparment dep : departamentos)
				streamSalida.writeObject(dep);
			if (streamSalida != null)
				streamSalida.close();
		} catch (IOException e1) {
			System.out.println("ERROR: "+e1.getMessage());
		}
	}
	
	/** 
	 * Crear un fichero con al menos 10 empleados de prueba de tres departamentos diferentes
	 */
	private void dummy() {
		
		// Listado de empleados
		employeeList.add(new Employee(1, "Martin", "Miguel", "desarrollador", 4000, 1, 10,"01/01/2014"));
		employeeList.add(new Employee(2, "Martin", "Miguel", "desarrollador", 4000, 1, 10,"01/01/2014"));
		employeeList.add(new Employee(3, "Martin", "Miguel", "desarrollador", 4000, 1, 10,"01/01/2014"));
		employeeList.add(new Employee(4, "Martin", "Miguel", "desarrollador", 4000, 1, 10,"01/01/2014"));
		employeeList.add(new Employee(5, "Martin", "Miguel", "desarrollador", 4000, 1, 10,"01/01/2014"));
		employeeList.add(new Employee(6, "Martin", "Miguel", "desarrollador", 4000, 1, 10,"01/01/2014"));
		ObjectOutputStream streamSalida = null;
		
		departamentos.add(new Deparment(1154,"Ventas","Francisco Peando"));
		departamentos.add(new Deparment(1154,"Contabilidad","Carlos Cantautor"));
		departamentos.add(new Deparment(1154,"I+D","Owen Calzadilla"));
		
		try {
			// escribimos
			streamSalida = new ObjectOutputStream(new FileOutputStream(pathEmp));
			for (Employee emp : employeeList)
				streamSalida.writeObject(emp);
			if (streamSalida != null)
				streamSalida.close();
		} catch (IOException e1) {
			System.out.println("ERROR: "+e1.getMessage());
		}
		
		try {
			// escribimos
			streamSalida = new ObjectOutputStream(new FileOutputStream(pathDep));
			for (Deparment dep : departamentos)
				streamSalida.writeObject(dep);
			if (streamSalida != null)
				streamSalida.close();
		} catch (IOException e1) {
			System.out.println("ERROR: "+e1.getMessage());
		}
	}
	
	// crea un método que liste un empleado por su id. 
	public Employee getEmployee (int idEmp){
		int i;
		for(i = 0; i<employeeList.size(); i++){
			if(employeeList.get(i).getId()==idEmp)
				break;
		}
		return employeeList.get(i);
	}
	
	// Crear un método que modifique el salario de un empleado con el id que recibe y el nuevo salario por parámetro
	public boolean getEmployee (int idEmp, double newSalary){
		boolean done = false;
		for(int i = 0; i<employeeList.size(); i++){
			if(employeeList.get(i).getId()==idEmp){
				employeeList.get(i).setSalary(newSalary);
				done = true;
			}
		}
		return done;
	}
	// Crear un método que elimine un empleado con el id que recibe por parámetro
	public boolean deleteEmployee (int id){
		boolean done = false;
		for(int i = 0; i<employeeList.size(); i++){
			if(employeeList.get(i).getId()==id){
				employeeList.remove(i);
				done = true;
			}
		}
		return done;
	}
	
	// Crear un método que añada un nuevo empleado recibiendo los datos por parámetro
	public boolean addEmployee (Employee e){
		employeeList.add(e);
		return true;
	}
	
	// Crear un método que devuelva los empleados ordenados por apellido en un ArrayList
	public ArrayList<Employee> listEmployee (){
		ArrayList<Employee> employeeList_ord = employeeList; 
		Collections.sort(employeeList_ord, new Comparator<Employee>(){	 
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp1.getLastName().compareTo(emp2.getLastName());
			}
		});	
		return employeeList_ord;
	}
	
	// Crear un método que devuelva el número de empleados de un departamento
	public int numEmployeeDepartment (int idDep){
		int cont=0;
		for(int i = 0; i<employeeList.size(); i++){
			if(employeeList.get(i).getDepNumber()==idDep)
				cont++;
		}
		return cont;
	}
	// Crear un método que devuelva la lista de departamentos sin repetir en un ArrayList
	public ArrayList<Deparment> getDepartment (){
		return departamentos;
	}
	
	// Crear un método que devuelva el sueldo medio de los empleados de un departamento recibido por parámetro
	public int averagePaymentDepartment (int idDep){
		int payment=0;
		for(int i = 0; i<employeeList.size(); i++){
			if(employeeList.get(i).getDepNumber()==idDep)
				payment += employeeList.get(i).getSalary();
		}
		return payment;
	}
	
	
}