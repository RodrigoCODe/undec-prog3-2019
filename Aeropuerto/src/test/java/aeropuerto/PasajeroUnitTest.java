package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PasajeroUnitTest {

	@Test
	@DisplayName("InstanciarPasajeroTest")
	public void InstanciarPasajero_TodosLosArchivos_InstanciaCorrecta() throws StringNuloException, ValorNegativoException {
		//arrange y act
		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
		//assert
		assertSame(1, unPasajero.getIdPasajero());
		assertEquals("20-211237733-4", unPasajero.getCuil());
		assertEquals("Ruiz", unPasajero.getApellido());
		assertEquals("Alberto", unPasajero.getNombres());
		assertEquals("0382512312313", unPasajero.getTelefono());
	} 
	 
	@Test
	@DisplayName("InstanciarPasajeroSinId")
	public void InstanciarPasajer_TodosLosArchivos_PasajeroSinIdException() {
		//arrange y act 
		assertThrows(ValorNegativoException.class, () -> new Pasajero(0, "20-24949334-2", "Ruiz","Luis, Fernando", ""));
		assertThrows(ValorNegativoException.class, () -> new Pasajero(-1,"21-23345533-1","Aballay","Juana", "038251231231"));
		Throwable myException = assertThrows(NullPointerException.class, () -> new Pasajero(null, "20-26323452-3","Perez", "Juan","03825424566"));
		System.out.println(myException.getMessage());
		assertEquals("El id de un pasajero No puede ser Nulo", myException.getMessage()); 
	}
	
	@Test
	@DisplayName("InstanciarPasajeroSinCuilTest")
	public void InstanciarPasajero_TodosLosArchivos_PasajeroSinCuilException() 
			throws StringNuloException, ValorNegativoException{
		//arrange y act
		assertThrows(StringNuloException.class, () -> new Pasajero(1, "", "Ruiz","Luis, Fernando", ""));
		assertThrows(StringNuloException.class, () -> new Pasajero(2,null,"Aballay","Juana", "038251231231"));
		
	}
	
	@Test
	@DisplayName("InstanciarPasajeroSinApellidoTest")
	public void InstanciarPasajer_TodosLosArchivos_PasajeroSinApellidoException() {
		//arrange y act
		
		assertThrows(StringNuloException.class, () -> new Pasajero(1,"20-21231213-2", "","Luis, Fernando", "03825412132"));
		assertThrows(StringNuloException.class, () -> new Pasajero(2,"21-24423423-2",null,"Juana", "038251231231"));
				
	}
	
	@Test
	@DisplayName("InstanciarPasajeroSinNombresTest")
	public void InstanciarPasajero_TodosLosArchivos_PasajeroSinNombresException() {
		//arrange y act
		assertThrows(StringNuloException.class, () -> new Pasajero(1,"20-21231213-2", "Ruiz","", "03825412132"));
		assertThrows(StringNuloException.class, () -> new Pasajero(2,"21-24423423-2","Aballay",null, "038251231231"));
			
	}
	
	@Test
	@DisplayName("InstanciarPasajeroTelNuloTest")
	public void InstanciarPasajero_TodosLosArchivos_PasajeroTelefonoNullException() {
		//arrange y act
		assertThrows(StringNuloException.class, () -> new Pasajero(1,"20-21231213-2", "Ruiz","Luis, Alberto", null));
		assertThrows(StringNuloException.class, () -> new Pasajero(2,"21-24423423-2","Aballay","Juan",null));
					
	}
	
	
	
	

}
