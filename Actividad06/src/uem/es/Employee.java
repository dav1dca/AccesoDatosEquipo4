package uem.es;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id ;
	private int job;
	private String lastname;
	private String name;
	private Date regisDate;
	private int salary;
	private float commission;
	private int depNumber;
	private SimpleDateFormat format;
	static final String DATE_FORMAT = "dd/MM/yyyy";
	
	
///////////////////////////////////////////////////////////Constructores////////////////////////////////////////////////
	public Employee(int id, String lastname, String name, int job,
			String regisDate, int salary, float commission, int depNumber) {
		format = new SimpleDateFormat();
		setId(id);
		setLastname(lastname);
		setName(name);
		setJob(job);
		setRegisDate(regisDate);
		setSalary(salary);
		setCommission(commission);
		setDepNumber(depNumber);
		
	}
	
	public Employee() {
		format = new SimpleDateFormat();
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
	public int getJob() {
		return job;
	}
	public void setJob(int job) {
		this.job = job;
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


	public String getRegisDate() {
		return format.format(regisDate);
		 
	}
	
	//Gestion fecha
	public void setRegisDate(String regisDate) {
		try{
		
			this.regisDate = new SimpleDateFormat(DATE_FORMAT).parse(regisDate);
		}
		catch (Exception e){
			System.err.println("Error en el formato de fecha");
			this.regisDate = new Date();
		}
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastname=" + lastname + ", name="
				+ name + ", job=" + job + ", regisDate=" + getRegisDate()
				+ ", salary=" + salary + ", commission=" + commission
				+ ", depNumber=" + depNumber +"]";
	}
	
	
	
}
