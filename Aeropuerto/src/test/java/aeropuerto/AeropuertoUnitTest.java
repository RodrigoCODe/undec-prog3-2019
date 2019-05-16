package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AeropuertoUnitTest {

	@Test
	@DisplayName("InstanciarAeropuertoTest")
	public void InstanciarAeropuerto_TodosLosArchivos_InstanciaCorrecta() 
			throws ValorNegativoException, StringNuloException, ObjetoNoEncontradoException {
		//arrange y act
		Ciudad Cordoba = new Ciudad(1,"Cordoba","5000");   
		
		Aeropuerto elAeropuerto = new Aeropuerto(1,"Aeropuerto Cordoba", "CBA", Cordoba);
		
		//assert
		assertSame(1, elAeropuerto.getIdAeropuerto());   
		assertEquals("Aeropuerto Cordoba", elAeropuerto.getNombre());
		assertEquals("CBA", elAeropuerto.getCodigo());
		assertEquals(Cordoba, elAeropuerto.getLaCiudad());
	}
	
	@Test
	@DisplayName("InstanciarAeropuertoSinIdTest")
	public void InstanciarAeropuerto_TodosLosArchivos_AeropuertoSinIdException () 
			throws ValorNegativoException, StringNuloException, ObjetoNoEncontradoException {  
		//arrange y act
		Ciudad BuenosAires = new Ciudad(2, "Buenos Aires", "B1675");
		 
		//assert
		assertThrows(ValorNegativoException.class, () -> new Aeropuerto(0, "Aeropuerto Buenos Aires", "BA", BuenosAires)); 
		assertThrows(ValorNegativoException.class, () -> new Aeropuerto(-1,"Aeropuerto Buenos Aires", "BA", BuenosAires));
		Throwable myException = assertThrows(NullPointerException.class, ()  -> new Aeropuerto(null, "Aeropuerto Buenos Aires", "BA", BuenosAires));
		System.out.println(myException.getMessage()); 
		assertEquals("El id de Aeropuerto No puede ser Nulo", myException.getMessage());  
	}
	
	@Test
	@DisplayName("InstanciarAeropuertoSinNombreTest")
	public void InstanciarAeropuerto_TodosLosArchivos_AeropuertoSinNombreException() 
			throws NullPointerException, StringNuloException, ValorNegativoException {
		//arrange y act
		Ciudad BuenosAires = new Ciudad(2, "Buenos Aires", "B1675");
				
		//assert
		assertThrows(StringNuloException.class, () -> new Aeropuerto(1, "", "BA", BuenosAires)); 
		assertThrows(StringNuloException.class, () -> new Aeropuerto(1,null, "BA", BuenosAires));
		
	}
	
	@Test 
	@DisplayName("InstanciarAeropuertoSinCodigoTest")
	public void InstanciarAeropuerto_TodosLosArchivos_AeropuertoSinCodigoException() 
			throws NullPointerException, StringNuloException, ValorNegativoException {
		//arrange y act
		Ciudad BuenosAires = new Ciudad(2, "Buenos Aires", "B1675");
						
		//assert
		assertThrows(StringNuloException.class, () -> new Aeropuerto(1,"Aeropuerto Buenos Aires", "", BuenosAires)); 
	 	assertThrows(StringNuloException.class, () -> new Aeropuerto(1,"Aeropuerto Buenos Aires", null, BuenosAires));
	}
	
	@Test 
	@DisplayName("InstanciarAeropuertoSinCiudadTest")
	public void InstanciarAeropuerto_TodosLosArchivos_AeropuertoSinCiudadException()  
			throws ObjetoNoEncontradoException {
		 								
		//assert
		assertThrows(ObjetoNoEncontradoException.class, () -> new Aeropuerto(1,"Aeropuerto Buenos Aires", "BA", null)); 
		
	}   
	

}
