package aeropuerto;

@SuppressWarnings("serial")

public class FechaIncorrectaException extends Exception {

	public FechaIncorrectaException(String mensaje) {
		super(); 
		System.out.println(mensaje); 
	}   
}
