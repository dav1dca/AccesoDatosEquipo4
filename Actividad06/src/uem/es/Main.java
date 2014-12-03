package uem.es;

import java.util.ArrayList;
import java.util.Date;

public class Main {
	
	static java.util.Scanner in;
	static EmployeeManager empMan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new java.util.Scanner(System.in);
		empMan = new EmployeeManager();
		menuMain();
	}
	
	/**
	 * Menu principal del programa
	 * @author David y Miguel
	 */
	private static void menuMain(){
		int option = -1;
		do{
			System.out.println("////Menu Inicial\\\\");
			System.out.println("1.-Obtener el empleado.");
			System.out.println("2.-Poner el salario del empleado.");
			System.out.println("3.-Borrar empleado.");
			System.out.println("4.-Añadir empleado.");
			System.out.println("5.-Obtener empleados.");
			System.out.println("6.-Obtener departamento del empleado.");
			System.out.println("7.-Obtener departamentos.");
			System.out.println("8.-Media salarial de departamento.");
			System.out.println("0.-Salir.");
			System.out.println("/////////////////////");
			System.out.print("Introduczca opcion: ");
			option = readInt();
			if(option!=0)
				optionSelected(option);
			else
				empMan.closeEmployeeManager();
		}while(option!=0);
	}

	private static void optionSelected(int option){
		int id;
		switch(option){
		// opcion 1
		case 1:
			System.out.print("Introduce Id del empleado: ");
			id=readInt();
			if(empMan.getEmployee(id)!= null)
				mostrarDatosEmp(empMan.getEmployee(id));
			else System.out.println("El empleado no existe");
			break;
			// opcion 2
		case 2:
			System.out.print("Introduce Id empleado: ");
			id=readInt();
			System.out.print("Intorduzca el salario del empleado: ");
			if(empMan.getEmployee(id, readDouble()))
				System.out.println("Salario cambiado correctamente.");
			else
				System.out.println("El cambio del salario no se ha podido realizar.");
			break;
			// opcion 3
		case 3:
			System.out.print("Introduce Id empleado: ");
			id=readInt();
			if(empMan.deleteEmployee(id))
				System.out.println("Empleado borrado exitosamente.");
			else
				System.out.println("El empleado seleccionado no se ha podido borrar");
			break;
			// opcion 4
		case 4:
			setNewEmpleado();
			break;
			// opcion 5
		case 5:
			 mostrarEmpleados(empMan.listEmployee());
			break;
			// opcion 6
		case 6:
			System.out.print("Introduce Id del departamento: ");
			id=readInt();
			System.out.println(empMan.numEmployeeDepartment(id));
			break;
			// opcion 7
		case 7: 
			mostrarDepartamentos(empMan.getDepartment());
			break;
			// opcion 8
		case 8:
			System.out.print("Introduce Id del departamento: ");
			id=readInt();
			System.out.println(empMan.averagePaymentDepartment(id));
			break;
		
		}
	}
	
	
	private static double readDouble(){
		try{
			return in.nextDouble();
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
			return 0.0d;
		}
	}
	
	
	private static float readFloat(){
		try{
			return in.nextFloat();
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
			return 0.0f;
		}
	}
	
	
	private static String readString(){
		try{
			return in.next();
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
			return "";
		}
	}
	
	
	private static int readInt(){
		try{
			return in.nextInt();
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
			return -1;
		}
	}
	
	private static void mostrarDatosEmp(Employee emp){
		System.out.println("/////////////Empleado\\\\\\\\\\\\\\\\");
		System.out.println("ID: "+emp.getId());
		System.out.println("Nombre: "+emp.getName()+" "+emp.getLastName());
		System.out.println("Trabajo: "+emp.getJob());
		System.out.println("Departamento: "+emp.getDepNumber());
		System.out.println("Fecha de inicio: "+emp.getDate());
		System.out.println("Salario: "+emp.getSalary());
		System.out.println("Comision: "+emp.getComission());
		System.out.println("//////////////////////////////////////");
		System.out.println("Presionar Enter");
		in.nextLine();
		in.nextLine();
	}
	
	private static void setNewEmpleado(){
		Date fecha = new Date();
		System.out.println("//Nuevo Empleado\\");
		System.out.print("ID: ");
		int id = readInt();
		System.out.print("Nombre: ");
		String name= readString();
		System.out.print("Apellido: ");
		String lastname= readString();
		System.out.print("Trabajo: ");
		String job = readString();
		System.out.print("Departamento: ");
		int dep = readInt();
		String date = Integer.toString(fecha.getDay())+"/"+Integer.toString(fecha.getMonth())+"/"+Integer.toString(fecha.getYear());
		System.out.print("Salario: ");
		double salary = readDouble();
		System.out.print("Comision: ");
		float comision = readFloat();
		System.out.println("-------------------------------------");
		empMan.addEmployee(new Employee(id, lastname, name, job, salary, comision, dep,date));
		
	}
	
	
	private static void mostrarEmpleados(ArrayList<Employee> empleados){
		for(Employee e: empleados){
			System.out.println("ID: "+e.getId()+"| nombre: "+e.getLastName()+"; "+e.getName());
		}
		System.out.println("Presionar Enter");
		in.nextLine();
		in.nextLine();
	}
	
	
	private static void mostrarDepartamentos(ArrayList<Deparment> departamentos){
		for(Deparment dep: departamentos){
			System.out.println("ID: "+dep.getId()+"| nombre: "+dep.getName()+"| Jefe de departamento: "+dep.getHead());
		}
		System.out.println("Presionar Enter");
		in.nextLine();
		in.nextLine();
	}
}