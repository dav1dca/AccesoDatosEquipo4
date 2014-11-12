package uem.es;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmployeeManager em = new EmployeeManager();
		
		em.crearFicheroPruebas();
		em.imprimirFicheroEmployee(EmployeeManager.FICHERO_PRUEBAS);
	}

}
