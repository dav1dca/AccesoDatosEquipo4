package uem.es;
import java.io.Serializable;

//clase departmaneto 
/**
 * @author David y Miguel
 */
public class Deparment implements Serializable {
	
	private int id;
	private String name;
	private String head;
	
	private static final long serialVersionUID = 1L;

	public Deparment() {

	}
	
	public Deparment(int id, String name, String head){
		this.id = id;
		this.name = name;
		this.head = head;
	}
	/**
	 * returns the id of the deparment
	 * @return int
	 */
	public int getId(){
		return id;
	}
	/**
	 * Returns a new name for the deparment
	 * @return String
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns the head of deparment
	 * @return String
	 */
	public String getHead(){
		return head;
	}
	/**
	 * Sets a new id por the deparment
	 * @param id
	 */
	public void SetId(int id){
		this.id = id;
	}
	/**
	 * Sets a new name for the deparment
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	public void SetHead(String head){
		this.head = head;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}