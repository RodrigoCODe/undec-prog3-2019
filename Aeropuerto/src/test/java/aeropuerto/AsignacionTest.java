package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AsignacionTest {

	@Test
	@DisplayName("AsignacionTest")
	public void InstanciarAsignacion_TodosLosAtributos_IntanciasCorrectas()
			throws StringNuloException, ValorNegativoException, ObjetoNoEncontradoException {
		//arrange y act
		Pasajero elPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
		
		Avion unAvion = new Avion(1,"Boeing 747", "XEOS939");
		
		Asiento elAsiento = unAvion.getLosAsientos().get(1); 
		 
		Asignacion laAsignacion = new Asignacion("1A",elPasajero, elAsiento);
		
		//assert
		
		assertEquals("1A", laAsignacion.getCodigoAsignacion());
		assertEquals("Alberto",laAsignacion.getElPasajero().getNombres());
		assertEquals("1", laAsignacion.getElAsiento().getNumeroAsiento()); 
	}

}
