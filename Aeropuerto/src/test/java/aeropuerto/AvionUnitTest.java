package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AvionUnitTest { 

	@Test
	@DisplayName("instanciarAvionTest")
	public void InstanciarAvion_TodosLosAtributos_instanciaCorrecta() throws NullPointerException, StringNuloException, ValorNegativoException { 
		//Arrange y act
		Avion unAvion = new Avion(1,"Boeing 747", "XEOS939"); 
		//assert  
		assertSame(1, unAvion.getIdAvion());
		assertEquals("Boeing 747",unAvion.getModelo());  
		assertEquals("XEOS939",unAvion.getMatricula());  
		assertEquals(23, unAvion.getLosAsientos().size());   
	}  
	
	@Test 
	@DisplayName("InstanciarAvionAvionSinId") 
	public void InstanciarAvion_TodosLosAtributos_AvionSinIdException() throws NullPointerException, ValorNegativoException {
		//arrange y act 
		assertThrows(ValorNegativoException.class, () -> new Avion(0, "Boeing 747", "XEOS939")); 
		assertThrows(ValorNegativoException.class, () -> new Avion(-1,"AirBus A320","XEOS452"));
		Throwable myException = assertThrows(NullPointerException.class, ()  -> new Avion(null, "Túpolev Tu-204","XEOS392"));
		System.out.println(myException.getMessage());
		assertEquals("El id de un Avion No puede ser Nulo", myException.getMessage()); 
	}
	    
	@Test 
	@DisplayName("InstaciarAvionSinModeloTest")
	public void InstanciarAvion_TodosLosAtributos_AvionSinModeloException() throws StringNuloException{
		//arrange y act 
		assertThrows(StringNuloException.class, () -> new Avion(1, "", "XEOS939")); 
		assertThrows(StringNuloException.class, () -> new Avion(2,null,"XEOS452"));
		assertThrows(StringNuloException.class, ()  -> new Avion(3, null,"XEOS392"));
		 
	}
	
	@Test 
	@DisplayName("InstanciarAvionSinMatriculaTest")
	public void InstanciarAvion_TodosLosAtributos_AvionSinMatricuaException() throws StringNuloException {
		//Arrange y act
		assertThrows(StringNuloException.class, () -> new Avion(1, "Boeing 747", "")); 
		assertThrows(StringNuloException.class, () -> new Avion(2,"AirBus A320",null));
		assertThrows(StringNuloException.class, ()  -> new Avion(3,"Túpolev Tu-204",""));
	} 
	 
	
 
}
