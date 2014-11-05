package uem.es;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements java.io.Serializable {
	private int id ;
	private String lastname;
	private String name;
	private String job;
	private Date regisDate;
	private int salary;
	private float commission;
	private int depNumber;
	
	static final String DATE_FORMAT = "dd/MM/yyyy";
///////////////////////////////////////////////////////////Constructores////////////////////////////////////////////////
	public Employee(int id, String lastname, String name, String job,
			Date regisDate, int salary, float commission, int depNumber) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.name = name;
		this.job = job;
		this.regisDate = regisDate;
		this.salary = salary;
		this.commission = commission;
		this.depNumber = depNumber;
	}
	
	public Employee() {
		super();
	}
//////////////////////////////////////////////////////Setters y Getters///////////////////////////////////////////////////
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//maximo 20
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		if (lastname.length()>20)
			this.lastname = lastname.substring(0, 20);
		else 
			this.lastname = lastname;
	}
	//maximo 20
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.length()>20)
			this.name = name.substring(0, 20);
		else
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getRegisDate() {
		return regisDate;
	}
	//Gestion fecha
	public void setRegisDate(String regisDate) {
		try{
			Date date = new SimpleDateFormat(DATE_FORMAT).parse(regisDate);
			this.regisDate = date;
		}
		catch (Exception e){
			System.err.println("Error en el formato de fecha");
			this.regisDate = new Date();
		}
	}
	public int getSalary() {
		return salary;
	}
	
	//Salario no puede ser negativo
	public void setSalary(int salary) {
		if (salary <= 0)
			this.salary = 0;
		else 
		this.salary = salary;
	}
	public float getCommission() {
		return commission;
	}
	//Comision no puede ser negativa
	public void setCommission(float commission) {
		if (depNumber <= 0)
			this.commission = 0;
		else 
			this.commission = commission;
	}
	public int getDepNumber() {
		return depNumber;
	}
	//DeptNumber no puede ser negativo
	public void setDepNumber(int depNumber) {
		if (depNumber <= 0)
			this.depNumber = 0;
		else 
			this.depNumber = depNumber;
	}
}
