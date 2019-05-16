package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VueloUnitTest {

	@Test
	@DisplayName("InstanciarVueloTest")
	public void InstanciarVuelo_TodosLosAtributos_InstanciasCorrectas() 
			throws NullPointerException, StringNuloException, ValorNegativoException, 
			ObjetoNoEncontradoException, ObjetoDuplicadoException, FechaIncorrectaException {
		//arrange y act
		//aeropuerto
		Ciudad Cordoba = new Ciudad(1,"Cordoba","5000");
		Ciudad BuenosAires = new Ciudad(2, "Buenos Aires", "B1675");
		
		Aeropuerto salida = new Aeropuerto(1,"Aeropuerto Cordoba", "CBA", Cordoba);
		Aeropuerto arribo = new Aeropuerto(2, "Aeropuerto Buenos Aires", "BA", BuenosAires);
		
		//Aerolinea
		
		Aerolinea unaAerolinea = new Aerolinea(1, "FlyBondi");
		
		//fechas
		
		LocalDateTime fechaHoraSalida = LocalDateTime.of(2019, 5, 15, 11, 00, 00);
		LocalDateTime fechaHoraArribo = LocalDateTime.of(2019, 5, 17, 11, 30, 00);
		
		//pilotos
		
		GestorPiloto gt= new GestorPiloto();   
		  
 		Piloto unPiloto = new Piloto(1,"Ruiz","Alberto","28131367");
 		Piloto otroPiloto = new Piloto(2,"Perez","Juan, Fernando","26177127");
 		
 		 
  		gt.AgregarPiloto(unPiloto);
  		gt.AgregarPiloto(otroPiloto);
		
  		ArrayList<Piloto> losPilotosVuelo = gt.getLosPilotos();
  		
  		//pasajeros
  		
  		GestorPasajero gp= new GestorPasajero();   
		
 		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Niz","Mariana","0382512312313");
 		Pasajero otroPasajero = new Pasajero(2,"20-2423423233-5","Alarcon","Rodrigo, Oscar","0382534525");
 		Pasajero tercerPasajero = new Pasajero(3,"26-231245544-6","Macri","Franco", "03824131231");
 			 		
 		gp.getLosPasajeros().add(unPasajero); 
 		gp.getLosPasajeros().add(otroPasajero); 
 		gp.getLosPasajeros().add(tercerPasajero);
 		
 		ArrayList<Pasajero> losPasajerosVuelo = gp.getLosPasajeros();
 		
 		//Avion
 		
 		
 		Avion unAvion = new Avion(1,"Boeing 747", "XEOS939"); 
 		
 		
 		 
 		//Vuelo
 		
 	
 		
 		Vuelo elVuelo = new Vuelo("Vuelo1", salida, arribo, fechaHoraSalida, fechaHoraArribo, 
 				unaAerolinea, losPilotosVuelo, losPasajerosVuelo , unAvion);
 		
 		//assert
 		 
 	
 		assertEquals("Aeropuerto Cordoba", elVuelo.getSalida().getNombre());
 		assertEquals("Aeropuerto Buenos Aires", elVuelo.getArribo().getNombre());
 		assertEquals("FlyBondi", elVuelo.getLaAerolineaVuelo().getNombre());
 		assertEquals("2019-05-15T11:00", elVuelo.getFechaHoraSalida().toString());
 		assertEquals("2019-05-17T11:30", elVuelo.getFechaHoraArribo().toString());
 		assertEquals("Ruiz", elVuelo.getLosPilotosVuelo().get(0).getApellido());
 		assertEquals("26177127", elVuelo.getLosPilotosVuelo().get(1).getDocumento());
 		assertEquals("Mariana", elVuelo.getLosPasajerosAsignados().get(0).getElPasajero().getNombres());
 		assertEquals(2, elVuelo.getLosPilotosVuelo().size());
 		assertEquals(3, elVuelo.getLosPasajerosAsignados().size());
 		assertEquals("Boeing 747", elVuelo.getElAvionVuelo().getModelo());
 		assertEquals("XEOS939", elVuelo.getElAvionVuelo().getMatricula());
 		assertSame(2, elVuelo.getLosPasajerosAsignados().get(2).getElAsiento().getIdAsiento());
 		assertEquals("Alarcon", elVuelo.traerPasajeroPorNumeroDeAsiento("1").getApellido());
 
 		
	}

}
