package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GestorVueloUnitTest {

	@Test
	@DisplayName("AgregarVueloTest")
	public void AgregarVuelo_TodosLosAtributos_InstanciasCorrectas() throws NullPointerException, StringNuloException, ValorNegativoException, ObjetoNoEncontradoException, FechaIncorrectaException, ObjetoDuplicadoException {
		//arrange y act
		GestorVuelo gv = new GestorVuelo();
		
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
		 				unaAerolinea, losPilotosVuelo, losPasajerosVuelo, unAvion);
		
		
		Vuelo otroVuelo = new Vuelo("Vuelo2", salida, arribo, fechaHoraSalida, fechaHoraArribo, 
 				unaAerolinea, losPilotosVuelo, losPasajerosVuelo, unAvion);

		gv.AgregarVuelo(elVuelo);
		
		//assert
		
		assertEquals(1, gv.getLosVuelos().size());
		assertEquals("Vuelo1",gv.getLosVuelos().get(0).getCodigoVuelo());
		assertEquals("Alarcon",gv.getLosVuelos().get(0).getLosPasajerosAsignados().get(1).getElPasajero().getApellido());
		assertEquals("Boeing 747", gv.getLosVuelos().get(0).getElAvionVuelo().getModelo());
		assertEquals(3, gv.getLosVuelos().get(0).getLosPasajerosAsignados().size());
		assertThrows(ObjetoNoEncontradoException.class, () -> gv.AgregarVuelo(otroVuelo));
		
	}
	
	
	
	
	

}

