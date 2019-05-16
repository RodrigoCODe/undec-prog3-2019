package aeropuerto;

@SuppressWarnings("serial")

public class ObjetoDuplicadoException extends Exception {
	
	public ObjetoDuplicadoException(String mensaje) {
		super(); 
		System.out.println(mensaje); 
	}   
}
