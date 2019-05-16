package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AerolineaUnitTest { 

	@Test
	@DisplayName("instanciarAerolineaTes")
	public void InstanciarAerolinea_TodosLosAtributos_instanciaCorrecta() throws ValorNegativoException, StringNuloException{
		//arrange y act
		Aerolinea unaAerolinea = new Aerolinea(1, "FlyBondi");   
		
		//assert  
		assertSame(1, unaAerolinea.getId()); 
		assertEquals("FlyBondi", unaAerolinea.getNombre()); 
		 
	}
	 
	@Test
	@DisplayName("InstanciarAerolinea_TodosLosAtributos_AerolineaSinNombreException")
		public void InstanciarAerolineaSinNombreTest() throws StringNuloException { 
	
		//arrange y act 
	    
		assertThrows(StringNuloException.class, () -> new Aerolinea(1, null));
		assertThrows(StringNuloException.class, () -> new Aerolinea(2,null));
	      
	} 
	
	@Test 
	@DisplayName("InstanciarAerolinea_TodosLosAtributos_AerolineaSinIdException")
	public void InstanciarAerolineaSinIdTest() throws ValorNegativoException {
		//arrange y act 
		assertThrows(ValorNegativoException.class, () -> new Aerolinea(0, "FlyBondi")); 
		assertThrows(ValorNegativoException.class, () -> new Aerolinea(-1,"Lan"));
		Throwable myException = assertThrows(NullPointerException.class, ()  -> new Aerolinea(null, "Aeorlineas"));
		System.out.println(myException.getMessage());
		assertEquals("El id No puede ser Nulo", myException.getMessage());  
	}         
         
	    
}
