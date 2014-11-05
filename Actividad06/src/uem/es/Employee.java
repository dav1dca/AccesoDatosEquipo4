package uem.es;

import java.text.SimpleDateFormat;
import java.util.Date;


//atributos: id, lastname (20) name (20), job,
//regis_date, salary, commission, depNumber


public class Employee implements java.io.Serializable {
	private int id ;
	private String lastname;
	private String name;
	private String job;
	private Date regisDate;
	private int salary;
	private float commission;
	private int depNumber;
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
//////////////////////////////////////////////////////setters y getters///////////////////////////////////////////////////
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
	public void setRegisDate(String regisDate) {
		
		String oldstring = "2011-01-18 00:00:00.0";
		//Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
		//this.regisDate = date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public float getCommission() {
		return commission;
	}
	public void setCommission(float commission) {
		this.commission = commission;
	}
	public int getDepNumber() {
		return depNumber;
	}
	public void setDepNumber(int depNumber) {
		this.depNumber = depNumber;
	}
	
	
	
	
}
