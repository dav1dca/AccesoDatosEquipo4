package uem.es;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author David y Miguel
 */
public class Employee implements Serializable {

	private int id;
	private String lastname;
	private String name;
	private String job;
	private Date regis_date;
	private double salary;
	private float comission;
	private int depNumber;
	private static final int STRINGSIZE = 20;
	private static final long serialVersionUID = 1L;

	public Employee() {

	}

	public Employee(int id, String lastname, String name, String jobs,
			double salary, float comission, int depNumber, String date) {
		this.setId(id);
		this.setLastName(lastname);
		this.setName(name);
		this.setJob(jobs);
		this.setDate(date);
		this.setSalary(salary);
		this.setComission(comission);
		this.setDepNumber(depNumber);
	}

	/**
	 * Returns the id of the employee
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name of the employee
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the last name of the employee
	 * 
	 * @return String
	 */
	public String getLastName() {
		return lastname;
	}

	/**
	 * Returns the job of the employee
	 * 
	 * @return String
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Returns the date the employee started working
	 * 
	 * @return Date
	 */
	public String getDate() {
		return new SimpleDateFormat("dd/MM/yyyy").format(regis_date);
	}

	/**
	 * Returns the salary of the employee
	 * 
	 * @return Long
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Returns the comission of the employee
	 * 
	 * @return float
	 */
	public float getComission() {
		return comission;
	}

	/**
	 * Returns the deparment number of the employee
	 * 
	 * @return int
	 */
	public int getDepNumber() {
		return depNumber;
	}

	/**
	 * Sets a new id for the employee
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets a new name for the employee
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() > STRINGSIZE)
			this.name = name.substring(0, STRINGSIZE);
		else
			this.name = name;
	}

	/**
	 * Sets a new lastName for the employee
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		if (lastName.length() > STRINGSIZE)
			this.lastname = lastName.substring(0, STRINGSIZE);
		else
			this.lastname = lastName;
	}

	/**
	 * Sets a new job for the employee
	 * 
	 * @param job
	 */
	public void setJob(String job) {
		if (job.length() > STRINGSIZE)
			this.job = job.substring(0, STRINGSIZE);
		else
			this.job = job;
	}

	/**
	 * Sets a new comission for the employee
	 * 
	 * @param comission
	 */
	public void setComission(float comission) {
		if (comission < 0)
			this.comission = 0;
		else
			this.comission = comission;
	}

	/**
	 * Sets a new working date for the employee
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		try {
			this.regis_date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Sets a new salary for the employee
	 * 
	 * @param salary
	 */
	public void setSalary(double salary) {
		if (salary < 0)
			this.salary = 0;
		else
			this.salary = salary;
	}

	/**
	 * Sets a new deparment number for the employee
	 * 
	 * @param dep
	 */
	public void setDepNumber(int dep) {
		this.depNumber = dep;
	}

	@Override
	public boolean equals(Object obj) {
		Employee e1 = (Employee) obj;
		return (e1.getId() == this.getId()) && (e1.getName() == this.getName())
				&& (e1.getLastName() == this.getLastName());

	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("");
		str.append(id).append(name).append(lastname).append(job).append(salary)
				.append(getDate());
		return str.toString();
	}

}