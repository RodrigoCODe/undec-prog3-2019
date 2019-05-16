package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GestorAerolineaUnitTest {
 
	@Test 
	@DisplayName("AgregarAerolineaTest")
	public void AgregarAerolinea_TodosLosAtributos_InstanciasCorrectas() throws ValorNegativoException, StringNuloException {
		//arrange y act 
		GestorAerolinea ga= new GestorAerolinea();   
		 
 		Aerolinea unaAerolinea = new Aerolinea(1, "FlyBondi"); 
 		Aerolinea otraAerlinea = new Aerolinea(2, "Lan");
 		Aerolinea tercerAerolinea = new Aerolinea(3, "Aerolineas Argentinas");
 		 
  		ga.AgregarAerolinea(unaAerolinea);
  		ga.AgregarAerolinea(otraAerlinea);
  		ga.AgregarAerolinea(tercerAerolinea); 
 		//assert   
 		assertEquals(3,ga.getLasAerolineas().size());  
 		assertEquals("Aerolineas Argentinas", ga.getLasAerolineas().get(2).getNombre()); 
	}  
	  
	@Test
	@DisplayName("ActualizarNombreAerolineaTest")
	public void ActualizarNombreAerolinea_TodosLosAtributos_InstanciasCorrectas() throws ValorNegativoException, StringNuloException {  
		//arrange y act
		GestorAerolinea ga= new GestorAerolinea();  
		
 		Aerolinea unaAerolinea = new Aerolinea(1, "FlyBondi");
 		Aerolinea otraAerolinea = new Aerolinea(2,"Aerolineas Argentina");
 		
 		ga.getLasAerolineas().add(unaAerolinea);
 		ga.getLasAerolineas().add(otraAerolinea);
 		ga.ActualizarNombreAerolinea(ga.getLasAerolineas().get(1), "Fly Emirates"); 
 		//assert 
 		assertEquals(2,ga.getLasAerolineas().size()); 
 		assertEquals("Fly Emirates", ga.getLasAerolineas().get(1).getNombre());   
	} 
	 
	
	@Test
	@DisplayName("BorrarAerolineaTest")
	public void BorrarAerolinea_TodosLosAtributos_InstanciasCorrectas() throws ValorNegativoException, StringNuloException {
		//arrange y act
		GestorAerolinea ga= new GestorAerolinea(); 
		
 		Aerolinea unaAerolinea = new Aerolinea(1, "LAN");
 		Aerolinea otraAerolinea = new Aerolinea(2, "Aerolineas Argentinas");
 		
 		ga.getLasAerolineas().add(unaAerolinea);
 		ga.getLasAerolineas().add(otraAerolinea);
 		
 		//assert   
 		assertEquals(2, ga.getLasAerolineas().size());   
 		assertTrue(ga.BorrarAerolinea(otraAerolinea));  
 		assertEquals(1, ga.getLasAerolineas().size());
		
	}
	 
	@Test
	@DisplayName("TraerUnaAerolineaPorNombreTest")
	public void TraerUnaAerolineaPorNombre_TodosLosAtributos_InstanciasCorrectas() throws ValorNegativoException, StringNuloException {
		//arrange y act
		GestorAerolinea ga= new GestorAerolinea(); 
	 	
 		Aerolinea unaAerolinea = new Aerolinea(1, "LAN");
 		Aerolinea otraAerolinea = new Aerolinea(2, "Aerolineas Argentinas");
 		Aerolinea tercerAerolinea = new Aerolinea(3,"Fly Emirates");
 		
 		ga.getLasAerolineas().add(unaAerolinea);
 		ga.getLasAerolineas().add(otraAerolinea);
 		ga.getLasAerolineas().add(tercerAerolinea);
 		  
 		Aerolinea traerPrimera = ga.TraerUnaAerolineaPorNombre("LAN"); 
 		Aerolinea traerSegunda = ga.TraerUnaAerolineaPorNombre("Fly Emirates");
  
 		//assert   
 		  
 		assertSame(1, traerPrimera.getId()); 
 		assertEquals("LAN", traerPrimera.getNombre()); 
 		assertSame(3, traerSegunda.getId()); 
 		assertEquals("Fly Emirates", traerSegunda.getNombre());
 	} 
	
	@Test
	@DisplayName("TraerUnaAerolineaPorIdTest")
	public void TraerUnaAerolineaPorNombre_TodosLosAtributos_InstanciasCorrectast() throws ValorNegativoException, StringNuloException {
		//arrange y act
		GestorAerolinea ga= new GestorAerolinea(); 
		
 		Aerolinea unaAerolinea = new Aerolinea(1, "LAN");
 		Aerolinea otraAerolinea = new Aerolinea(2, "Aerolineas Argentinas");
 		Aerolinea tercerAerolinea = new Aerolinea(3,"Fly Emirates");
 		
 		ga.getLasAerolineas().add(unaAerolinea);
 		ga.getLasAerolineas().add(otraAerolinea);
 		ga.getLasAerolineas().add(tercerAerolinea);
 		
 		Aerolinea traerPrimera = ga.TraerUnaAerolineaPorId(1);
 		Aerolinea traerSegunda = ga.TraerUnaAerolineaPorId(2);
  
 		//assert   
 		   
 		assertSame(1, traerPrimera.getId());  
 		assertEquals("LAN", traerPrimera.getNombre()); 
 		assertSame(2, traerSegunda.getId()); 
 		assertEquals("Aerolineas Argentinas", traerSegunda.getNombre());
 	} 
	
	@Test  
	@DisplayName("TraerTodasLasAerolineasTest")
	public void TraerTodasLasAerolineas_TodosLosAtributos_InstanciasCorrectas() throws ValorNegativoException, StringNuloException {
		//arrange y act
		GestorAerolinea ga= new GestorAerolinea(); 
		 
		Aerolinea unaAerolinea = new Aerolinea(1, "LAN");
 		Aerolinea otraAerolinea = new Aerolinea(2, "Aerolineas Argentinas");
 		Aerolinea tercerAerolinea = new Aerolinea(3,"Fly Emirates");
 		 
 		ga.getLasAerolineas().add(unaAerolinea);
 		ga.getLasAerolineas().add(otraAerolinea);
 		ga.getLasAerolineas().add(tercerAerolinea);
 		 
 		ga.TraerTodasLasAerolineas();
 		
 		assertEquals("LAN",ga.TraerTodasLasAerolineas().get(0).getNombre()); 
 		assertEquals("Aerolineas Argentinas",ga.TraerTodasLasAerolineas().get(1).getNombre());
 		assertEquals("Fly Emirates",ga.TraerTodasLasAerolineas().get(2).getNombre());
	}
		

}
