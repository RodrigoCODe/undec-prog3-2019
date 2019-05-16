package aeropuerto;

@SuppressWarnings("serial")

public class ValorNegativoException extends Exception {
	 
	public ValorNegativoException(String mensaje) {
		super(); 
		System.out.println(mensaje); 
	}   
	
}
