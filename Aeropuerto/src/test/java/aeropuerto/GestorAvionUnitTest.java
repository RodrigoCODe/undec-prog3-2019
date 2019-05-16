package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GestorAvionUnitTest {

	
		@Test 
		@DisplayName("AgregarAvionTest")
		public void AgregarAvion_TodosLosAtributos_InstanciasCorrectas() throws 
		ValorNegativoException, StringNuloException, ObjetoNoEncontradoException {
			//arrange y act 
			GestorAvion gv= new GestorAvion();  
			
	 		Avion unAvion = new Avion(1,"Boeing 747", "XEOS939"); 
	 		Avion otroAvion = new Avion(2,"AirBus A320","XEOS452");
	 		Avion tercerAvion = new Avion(3, "Túpolev Tu-204","XEOS392");
	 		Avion elMismoAvion = new Avion(1, "Boeing 747", "XEOS939");
	 		 
	  		gv.AgregarAvion(unAvion);
	  		gv.AgregarAvion(otroAvion);  
	  		gv.AgregarAvion(tercerAvion); 
	  		
	 		//assert   
	 		assertEquals(3,gv.getLosAviones().size());  
	 		assertEquals("Boeing 747", gv.getLosAviones().get(0).getModelo());
	 		assertSame(1, gv.getLosAviones().get(0).getIdAvion()); 
	 		assertThrows(ObjetoNoEncontradoException.class, () -> gv.AgregarAvion(elMismoAvion)); 
	 		
		} 
		 
		@Test
		@DisplayName("ActualizarMatriculaAvionTest")
		public void ActualizarMatriculaAvion_TodosLosAtributos_InstanciasCorrectas() throws 
		ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
			//arrange y act
			GestorAvion gv= new GestorAvion();   
			
	 		Avion unAvion = new Avion(1, "Boeing 747", "XEOS939");
	 		Avion otroAvion = new Avion(2,"AirBus A320","XEOS452");
	 		Avion elAvion = new Avion(3,"Boeing 747", "XE9999");
	 		
	 		gv.getLosAviones().add(unAvion); 
	 		gv.getLosAviones().add(otroAvion); 
	 			 		
	 		gv.ActualizarMatriculaAvion(unAvion, "XEYS900");   
	 		gv.ActualizarMatriculaAvion(otroAvion, "XEYS915");
	 		//assert 
	 		assertEquals(2,gv.getLosAviones().size()); 
	 		assertEquals("XEYS900", gv.getLosAviones().get(0).getMatricula()); 
	 		assertEquals("XEYS915", gv.getLosAviones().get(1).getMatricula()); 
	 		assertThrows(ObjetoNoEncontradoException.class, () -> gv.ActualizarMatriculaAvion(elAvion, "XEYS888")); 
		}  
		 
		@Test
		@DisplayName("BorrarAvionTest")
		public void BorrarAvion_TodosLosAtributos_InstanciasCorrectas() throws 
		ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
			//arrange y act
			GestorAvion gv= new GestorAvion();   
			
	 		Avion unAvion = new Avion(1, "Boeing 747", "XEOS939");
	 		Avion otroAvion = new Avion(2,"AirBus A320","XEOS452");
	 		Avion elAvion = new Avion(3,"Boeing 747", "XE9999");
	 			 		
	 		gv.getLosAviones().add(unAvion); 
	 		gv.getLosAviones().add(otroAvion); 
	 			 		
	 		 
	 		//assert 
	 		assertEquals(2,gv.getLosAviones().size());
	 		assertTrue(gv.BorrarAvion(otroAvion));
	 		assertThrows(ObjetoNoEncontradoException.class, () -> gv.BorrarAvion(elAvion)); 
		}   
		
		@Test
		@DisplayName("TraerAvionPorMatriculaTest")
		public void TraerAvionPorMatricula_TodosLosAtributos_InstanciasCorrectas() throws 
		ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
			//arrange y act
			GestorAvion gv= new GestorAvion();   
			
	 		Avion unAvion = new Avion(1, "Boeing 747", "XEOS939");
	 		Avion otroAvion = new Avion(2,"AirBus A320","XEOS452");
	 		Avion elAvion = new Avion(3,"Boeing 747", "XE9999");
	 			 		
	 		gv.getLosAviones().add(unAvion); 
	 		gv.getLosAviones().add(otroAvion); 
	 		
	 		Avion comparaAvion1 = gv.TraerAvionPorMatricula("XEOS939");
	 		Avion comparaAvion2 = gv.TraerAvionPorMatricula("XEOS452");
	 		 			 			 		 
	 		//assert 
	 		assertEquals(2,gv.getLosAviones().size());
	 		assertTrue(unAvion.getIdAvion().equals(comparaAvion1.getIdAvion()));   
	 		assertTrue(otroAvion.getIdAvion().equals(comparaAvion2.getIdAvion())); 
	 		assertThrows(ObjetoNoEncontradoException.class, () -> gv.TraerAvionPorMatricula("XE9999")); 
		}   
		
		@Test
		@DisplayName("TraerAvionesPorModelo")
		public void TraerAvionesPorModelo_TodosLosAtributos_InstanciasCorrectas() throws 
		ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
			//arrange y act
			GestorAvion gv= new GestorAvion();   
			
	 		Avion unAvion = new Avion(1, "Boeing 747", "XEOS939");
	 		Avion otroAvion = new Avion(2,"AirBus A320","XEOS452");
	 		Avion elAvion = new Avion(3,"Boeing 747", "XE9999");
	 		Avion tercerAvion = new Avion(4,"AirBus A320", "XEOS987");
	 		Avion CuartoAvion = new Avion(5, "AirBus A320", "XEOS877");
	 			 		
	 		gv.getLosAviones().add(unAvion); 
	 		gv.getLosAviones().add(otroAvion); 
	 		gv.getLosAviones().add(elAvion);
	 		gv.getLosAviones().add(tercerAvion);
	 		gv.getLosAviones().add(CuartoAvion);
	 		
	 		ArrayList<Avion> AvionesBoeing = gv.TraerAvionesPorModelo("Boeing 747");
	 		ArrayList<Avion> AvionesAirBus = gv.TraerAvionesPorModelo("AirBus A320"); 
	 			 		 			 			 		 
	 		//assert 
	 		assertEquals(5,gv.getLosAviones().size()); 
	 		assertEquals(2,AvionesBoeing.size());
	 		assertEquals(3,AvionesAirBus.size());
	 		assertEquals("Boeing 747", AvionesBoeing.get(0).getModelo());
	 		assertEquals("AirBus A320", AvionesAirBus.get(0).getModelo());
	 		assertThrows(ObjetoNoEncontradoException.class, () -> gv.TraerAvionesPorModelo("Túpolev Tu-204")); 
		}    
		
		@Test
		@DisplayName("TraerAvionPorIdAvion")
		public void TraerAvionPorIdAvion_TodosLosAtributos_InstanciasCorrectas() throws 
		ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
			//arrange y act
			GestorAvion gv= new GestorAvion();   
			
	 		Avion unAvion = new Avion(1, "Boeing 747", "XEOS939");
	 		Avion otroAvion = new Avion(2,"AirBus A320","XEOS452");
	 		Avion elAvion = new Avion(3,"Boeing 747", "XE9999");
	 		Avion tercerAvion = new Avion(4,"AirBus A320", "XEOS987");
	 		Avion CuartoAvion = new Avion(5, "AirBus A320", "XEOS877");
	 			 		
	 		gv.getLosAviones().add(unAvion); 
	 		gv.getLosAviones().add(otroAvion); 
	 		gv.getLosAviones().add(elAvion);
	 		gv.getLosAviones().add(tercerAvion);
	 			 		
	 		Avion avion1 = gv.TraerAvionPorIdAvion(1);
	 		Avion avion2 = gv.TraerAvionPorIdAvion(2);
	 		Avion avion3 = gv.TraerAvionPorIdAvion(4);
	 			 		 			 			 		 
	 		//assert 
	 		assertEquals(4,gv.getLosAviones().size());  
	 		assertEquals("XEOS939",avion1.getMatricula());
	 		assertSame(2,avion2.getIdAvion()); 
	 		assertEquals("AirBus A320", avion3.getModelo());
	 		assertThrows(ObjetoNoEncontradoException.class, () -> gv.TraerAvionPorIdAvion(5)); 
		}    
		   
		
		
}
