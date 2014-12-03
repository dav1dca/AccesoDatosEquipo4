package uem.es;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author David y Miguel
 */
public class EmployeeTest {
	
	@Test
	public void testEmployeeConstructor(){
		Employee e1 = new Employee(10, "apellido", "nombre","desarrollador", 4000.0, 5f, 1000, "01/01/2010");
		assertEquals(10,e1.getId());
		assertEquals( "apellido", e1.getLastName());
		assertEquals("nombre", e1.getName());
		assertEquals("desarrollador", e1.getJob());
		assertEquals(5f, e1.getComission(), 0.0);
		assertEquals(4000.0, e1.getSalary(), 0.0);
		assertEquals(1000, e1.getDepNumber());
		assertEquals("01/01/2010", e1.getDate());
		
		String apellido = "apellidoapellidoapellidoapellidoapellido";
		String nombre= "nombrenombrenombrenombrenombrenombrenombre";
		String job = "programadorprogramadorprogramadorprogramador";
		e1 = new Employee(1, apellido,nombre ,job, -27.0, -10.5f, 12, "11/11/1911");
		assertEquals(1,e1.getId());
		assertEquals( apellido.substring(0, 20), e1.getLastName());
		assertEquals(nombre.substring(0,20), e1.getName());
		assertEquals(job.substring(0, 20), e1.getJob());
		assertEquals(0.0, e1.getComission(), 0.0);
		assertEquals(0.0, e1.getSalary(), 0.0);
		assertEquals(12, e1.getDepNumber());
		assertEquals("11/11/1911", e1.getDate());
	}

	@Test
	public void testEquals() {
		Employee e1 = new Employee(123, "apellido", "nombre","desarrollador", 2000.0, 10.5f, 12, "11/11/1911");
		Employee e2 = new Employee(122, "apellido", "nombre","desarrollador", 2000.0, 10.5f, 12, "11/11/1911");
		Employee e3 = new Employee(123, "apellido", "nombre","desarrollador", 2000.0, 10.5f, 12, "11/11/1911");
		Employee e4 = new Employee(123, "apellido2", "nombre2","desarrollador", 2000.0, 10.5f, 12, "11/11/1911");

		assertTrue(e1.equals(e3));
		assertFalse(e1.equals(e2));
		assertFalse(e1.equals(e4));
	}
	public void testToString(){
		String apellido = "apellido";
		String nombre = "nombre";
		String job = "programador";
		String date = "11/11/1911";
		Employee e1 = new Employee(123, apellido, nombre,job, 2000.0, 10.5f, 12, date);
		StringBuffer str = new StringBuffer("");
		str.append(123).append(apellido).append(nombre).append(job).append(2000.0).append(10.5f).append(12).append(date);
		assertEquals(str, e1.toString());
}

}