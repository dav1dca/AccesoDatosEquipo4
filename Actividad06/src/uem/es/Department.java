package uem.es;

public class Department implements java.io.Serializable {
	
	/**
	 * @author Guillermo Valenzuela
	 */
	
	private static final long serialVersionUID = 772598062944144462L;

private String name;
private int id;
private int head;
/**
 * constructor vacio
 */
 public Department(){
	
}
 /**
  * 
  * @param name
  * @param id
  * @param head
  */
public Department(String name, int id, int head){
	this.name = name;
	this.id = id;
	this.head = head;
}
public String getName(){
	return name;
}
public int getId(){
	return id;
}
public int getHead(){
	return head;
}
public void setName(String name){
	 this.name=name;
}
public void setId(int id){
	 this.id=id;
}
public void setHead(int head){
	 this.head=head;
}
/**
 * devuelve el name, id y head
 */
@Override
public String toString(){
	return this.name + "\t"+ this.id + "\t" + this.head;
}
/**
 * metodo que compara el objeto departamento
 */
@Override
public boolean equals(Object otherDepartament){
	Department dep = (Department) otherDepartament;
	if((this.id== dep.id) && (this.head== dep.head) && (this.name== dep.name)){
	return true;
	}else return false;
}
}
