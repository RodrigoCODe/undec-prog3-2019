package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CiudadUnitTest {

	@Test
	@DisplayName("instanciarCiudad_TodosLosArchivos_InstanciaCorrecta")
	public void InstanciarCiudadTest() throws 
	NullPointerException, StringNuloException, ValorNegativoException {
		//arrange y act 
		Ciudad unaCiudad = new Ciudad(1,"Cordoba","5000");
		//assert
		assertSame(1, unaCiudad.getIdCiudad());   
		assertEquals("Cordoba", unaCiudad.getNombre());   
		assertEquals("5000", unaCiudad.getCodigoPostal()); 
		
	}
	@Test
	@DisplayName("instanciarCiudad_TodosLosArchivos_IdCiudadException")
	public void InstanciarCiudadTestSinId() throws 
	NullPointerException, StringNuloException, ValorNegativoException {
		//arrange y act
		//arrange y act 
	    
		assertThrows(ValorNegativoException.class, () -> new Ciudad(0, "Cordoba", "5000")); 
		assertThrows(ValorNegativoException.class, () -> new Ciudad(-1,"Buenos Aires", "7373"));
		Throwable myException = assertThrows(NullPointerException.class, () -> new Ciudad(null, "Chilecito","5360")); 
		System.out.println(myException.getMessage());
		assertEquals("El idCiudad No puede ser Nulo", myException.getMessage());    
	} 
	
	@Test
	@DisplayName("instanciarCiudad_TodosLosArchivos_NombreCiudadException")
	public void InstanciarCiudadTestSinNombre() throws 
	NullPointerException, StringNuloException, ValorNegativoException {
		//arrange y act
		assertThrows(StringNuloException.class, () -> new Ciudad(1, "", "5000")); 
		assertThrows(StringNuloException.class, () -> new Ciudad(2,null, "7373"));  
		assertThrows(StringNuloException.class, () -> new Ciudad(3, null,"5360")); 
		
	}
	
	@Test
	@DisplayName("instanciarCiudad_TodosLosArchivos_CiudadIncompletaException_3")
	public void InstanciarCiudadTestSInCodigoPostal() throws 
	NullPointerException, StringNuloException, ValorNegativoException {
		//arrange y act
		assertThrows(StringNuloException.class, () -> new Ciudad(1, "Cordoba", ""));       
		assertThrows(StringNuloException.class, () -> new Ciudad(2,"Buenos Aires", null));
		assertThrows(StringNuloException.class, () -> new Ciudad(3, "Chilecito",null)); 
		 
	}
	
	

}
