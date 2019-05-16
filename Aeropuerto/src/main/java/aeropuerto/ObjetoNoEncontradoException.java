package aeropuerto;

@SuppressWarnings("serial")

public class ObjetoNoEncontradoException extends Exception {

		public ObjetoNoEncontradoException(String mensaje) {
			super(); 
			System.out.println(mensaje); 
		}   
		
}

