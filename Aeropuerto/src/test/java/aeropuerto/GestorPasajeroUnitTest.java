package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GestorPasajeroUnitTest {

	@Test 
	@DisplayName("AgregarPasajeroTest")
	public void AgregarPasajero_TodosLosAtributos_InstanciasCorrectas() 
			throws ValorNegativoException, StringNuloException, ObjetoDuplicadoException {
		//arrange y act 
		GestorPasajero gp= new GestorPasajero();   
		 
 		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
 		Pasajero otroPasajero = new Pasajero(2,"20-2423423233-5","Perez","Juan, Fernando","0382534525");
 		Pasajero tercerPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
 		 
  		gp.AgregarPasajero(unPasajero);
  		gp.AgregarPasajero(otroPasajero);
  		 
 		//assert   
 		assertEquals(2,gp.getLosPasajeros().size());  
 		assertEquals("Juan, Fernando", gp.getLosPasajeros().get(1).getNombres()); 
 		assertThrows(ObjetoDuplicadoException.class, () -> gp.AgregarPasajero(tercerPasajero));
	}  
	
	@Test
	@DisplayName("ActualizarTelefonoPasajeroTest")
	public void ActualizarTelefonoPasajero_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		//arrange y act
		GestorPasajero gp= new GestorPasajero();   
		
		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
 		Pasajero otroPasajero = new Pasajero(2,"20-2423423233-5","Perez","Juan, Fernando","0382534525");
 		Pasajero tercerPasajero = new Pasajero(3,"26-231245544-6","Macri","Franco", "03824131231");
 		
 		gp.getLosPasajeros().add(unPasajero); 
 		gp.getLosPasajeros().add(otroPasajero); 
 			 		
 		gp.ActualizarTelefonoPasajero(unPasajero, "0351-413422"); 
 		gp.ActualizarTelefonoPasajero(otroPasajero, "011-12415453");
 		//assert 
 		assertEquals(2,gp.getLosPasajeros().size()); 
 		assertEquals("0351-413422", gp.getLosPasajeros().get(0).getTelefono()); 
 		assertEquals("011-12415453", gp.getLosPasajeros().get(1).getTelefono()); 
 		assertThrows(ObjetoNoEncontradoException.class, () -> gp.ActualizarTelefonoPasajero(tercerPasajero, "03824131231")); 
	}   
	
	@Test
	@DisplayName("BorrarPasajeroTest")
	public void BorrarPasajero_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		//arrange y act
		GestorPasajero gp= new GestorPasajero();   
		
		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
 		Pasajero otroPasajero = new Pasajero(2,"20-2423423233-5","Perez","Juan, Fernando","0382534525");
 		Pasajero tercerPasajero = new Pasajero(3,"26-231245544-6","Macri","Franco", "03824131231");
 			 		
 		gp.getLosPasajeros().add(unPasajero); 
 		gp.getLosPasajeros().add(otroPasajero); 
 			 		
 		 
 		//assert 
 		assertEquals(2,gp.getLosPasajeros().size());
 		assertTrue(gp.BorrarPasajero(unPasajero));
 		assertTrue(gp.BorrarPasajero(otroPasajero));
 		assertEquals(0,gp.getLosPasajeros().size());
 		assertThrows(ObjetoNoEncontradoException.class, () -> gp.BorrarPasajero(tercerPasajero)); 
	}   
	
	@Test
	@DisplayName("TraerPasajeroPorId")
	public void TraerPasajeroPorId_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		//arrange y act
		GestorPasajero gp= new GestorPasajero();   
		
 		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
 		Pasajero otroPasajero = new Pasajero(2,"20-2423423233-5","Perez","Juan, Fernando","0382534525");
 		Pasajero tercerPasajero = new Pasajero(3,"26-231245544-6","Macri","Franco", "03824131231");
 			 		
 		gp.getLosPasajeros().add(unPasajero); 
 		gp.getLosPasajeros().add(otroPasajero); 
 		gp.getLosPasajeros().add(tercerPasajero);
 	
 			 		
 		Pasajero pasajero1 = gp.TraerPasajeroPorId(1);
 		Pasajero pasajero2 = gp.TraerPasajeroPorId(2);
 		Pasajero pasajero3 = gp.TraerPasajeroPorId(3);
 			 		 			 			 		 
 		//assert 
 		assertEquals(3,gp.getLosPasajeros().size());  
 		assertEquals("Juan, Fernando",pasajero2.getNombres());
 		assertSame(3,pasajero3.getIdPasajero()); 
 		assertEquals("20-211237733-4", pasajero1.getCuil());
 		assertThrows(ObjetoNoEncontradoException.class, () -> gp.TraerPasajeroPorId(5)); 
	}    
	
	@Test
	@DisplayName("TraerPasajeroPorCuil")
	public void TraerPasajeroPorCuil_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		//arrange y act
		GestorPasajero gp= new GestorPasajero();   
		
 		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Ruiz","Alberto","0382512312313");
 		Pasajero otroPasajero = new Pasajero(2,"20-2423423233-5","Perez","Juan, Fernando","0382534525");
 		Pasajero tercerPasajero = new Pasajero(3,"26-231245544-6","Macri","Franco", "03824131231");
 			 		
 		gp.getLosPasajeros().add(unPasajero); 
 		gp.getLosPasajeros().add(otroPasajero); 
 		gp.getLosPasajeros().add(tercerPasajero);
 	
 			 		
 		Pasajero pasajero1 = gp.TraerPasajeroPorCuil("20-211237733-4");
 		Pasajero pasajero2 = gp.TraerPasajeroPorCuil("20-2423423233-5");
 		Pasajero pasajero3 = gp.TraerPasajeroPorCuil("26-231245544-6");
 			 		 			 			 		 
 		//assert 
 		assertEquals(3,gp.getLosPasajeros().size());  
 		assertEquals("Juan, Fernando",pasajero2.getNombres());
 		assertSame(3,pasajero3.getIdPasajero()); 
 		assertEquals("20-211237733-4", pasajero1.getCuil());
 		assertThrows(ObjetoNoEncontradoException.class, () -> gp.TraerPasajeroPorCuil("20-281313822-3")); 
	}    
	
	@Test
	@DisplayName("TraerPasajerosPorApellido")
	public void TraerPasajeroPorApellido_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		//arrange y act
		GestorPasajero gp= new GestorPasajero();   
		
 		Pasajero unPasajero = new Pasajero(1,"20-211237733-4","Perez","Alberto","0382512312313");
 		Pasajero otroPasajero = new Pasajero(2,"20-2423423233-5","Perez","Juan, Fernando","0382534525");
 		Pasajero tercerPasajero = new Pasajero(3,"26-231245544-6","Macri","Franco", "03824131231");
 		Pasajero cuartoPasajero = new Pasajero(4,"26-231245544-6","Macri","Mauricio", "03824131231");
 			 		
 		gp.getLosPasajeros().add(unPasajero); 
 		gp.getLosPasajeros().add(otroPasajero); 
 		gp.getLosPasajeros().add(tercerPasajero);
 		gp.getLosPasajeros().add(cuartoPasajero);
 		
 		ArrayList<Pasajero> pasajerosPerez = gp.TraerPasajerosPorApellido("Perez");
 		ArrayList<Pasajero> pasajerosMacri = gp.TraerPasajerosPorApellido("Macri"); 
 			 		 			 			 		 
 		//assert 
 		assertEquals(4,gp.getLosPasajeros().size()); 
 		assertEquals(2,pasajerosPerez.size());
 		assertEquals(2,pasajerosMacri.size());
 		assertEquals("Alberto", pasajerosPerez.get(0).getNombres());
 		assertEquals("26-231245544-6", pasajerosMacri.get(0).getCuil());
 		assertThrows(ObjetoNoEncontradoException.class, () -> gp.TraerPasajerosPorApellido("Alarcon")); 
	}    
	
	

}
