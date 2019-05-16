package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PilotoUnitTest {

	@Test
	@DisplayName("InstanciarPilotoTest")
	public void instanciarPiloto_TodosLosAtributos_instanciaCorrecta() throws StringNuloException, ValorNegativoException {
		//arrange y act
		Piloto unPiloto = new Piloto(1, "Sanchez", "Juan", "22113445");
		//assert
		assertSame(1, unPiloto.getIdPiloto());
		assertEquals("Sanchez", unPiloto.getApellido());
		assertEquals("Juan", unPiloto.getNombres());
		assertEquals("22113445", unPiloto.getDocumento());
		
	}
	
	@Test
	@DisplayName("InstanciarPilotoSinId")
	public void InstanciarPiloto_TodosLosArchivos_PilotoSinIdException() {
		//arrange y act 
		assertThrows(ValorNegativoException.class, () -> new Piloto(0, "Ruiz","Luis, Fernando", "223114455"));
		assertThrows(ValorNegativoException.class, () -> new Piloto(-1,"Aballay","Juana", "245954944"));
		Throwable myException = assertThrows(NullPointerException.class, () -> new Piloto(null,"Perez", "Juan","235532226"));
		System.out.println(myException.getMessage());
		assertEquals("El id de un piloto No puede ser Nulo", myException.getMessage()); 
	}
	
	@Test
	@DisplayName("InstanciarPilotoSinApellidoTest")
	public void InstanciarPiloto_TodosLosArchivos_PilotoSinApellidoException() {
		//arrange y act
		
		assertThrows(StringNuloException.class, () -> new Piloto(1,"","Luis, Fernando", "2812131499"));
		assertThrows(StringNuloException.class, () -> new Piloto(2,null,"Juana", "27183182381"));
				
	}
	
	@Test
	@DisplayName("InstanciarPilotoSinNombresTest")
	public void InstanciarPiloto_TodosLosArchivos_PilotoSinNombresException() {
		//arrange y act
		assertThrows(StringNuloException.class, () -> new Piloto(1, "Ruiz","", "221231499"));
		assertThrows(StringNuloException.class, () -> new Piloto(2,"Aballay",null, "248585855"));
			
	}
	
	@Test
	@DisplayName("InstanciarPilotoDocumentoNuloTest")
	public void InstanciarPiloto_TodosLosArchivos_PilotoDocumentoNuloException() {
		//arrange y act
		assertThrows(StringNuloException.class, () -> new Piloto(1, "Ruiz","Luis, Alberto", ""));
		assertThrows(StringNuloException.class, () -> new Piloto(2, "Aballay","Juan",null));
					
	}

}
