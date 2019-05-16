package aeropuerto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GestorPilotoUnitTest {

	@Test 
	@DisplayName("AgregarPilotoTest")
	public void AgregarPiloto_TodosLosAtributos_InstanciasCorrectas() 
			throws ValorNegativoException, StringNuloException, ObjetoDuplicadoException {
		//arrange y act 
		GestorPiloto gt= new GestorPiloto();   
		  
 		Piloto unPiloto = new Piloto(1,"Ruiz","Alberto","28131367");
 		Piloto otroPiloto = new Piloto(2,"Perez","Juan, Fernando","26177127");
 		Piloto tercerPiloto = new Piloto(1,"Ruiz","Alberto","28131367");
 		 
  		gt.AgregarPiloto(unPiloto);
  		gt.AgregarPiloto(otroPiloto);
  		 
 		//assert   
 		assertEquals(2,gt.getLosPilotos().size());  
 		assertEquals("Juan, Fernando", gt.getLosPilotos().get(1).getNombres()); 
 		assertThrows(ObjetoDuplicadoException.class, () -> gt.AgregarPiloto(tercerPiloto));
	}  
	
	@Test
	@DisplayName("BorrarPilotoTest")
	public void BorrarPiloto_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		//arrange y act
		GestorPiloto gt= new GestorPiloto();   
		
		Piloto unPiloto = new Piloto(1,"Ruiz","Alberto","2832423424");
 		Piloto otroPiloto = new Piloto(2,"Perez","Juan, Fernando","272121811");
 		Piloto tercerPiloto = new Piloto(3,"Macri","Franco", "2981238128");
 			 		
 		gt.getLosPilotos().add(unPiloto); 
 		gt.getLosPilotos().add(otroPiloto); 
 			 		
 		 
 		//assert 
 		assertEquals(2,gt.getLosPilotos().size());
 		assertTrue(gt.BorrarPiloto(unPiloto));
 		assertTrue(gt.BorrarPiloto(otroPiloto));
 		assertEquals(0,gt.getLosPilotos().size());
 		assertThrows(ObjetoNoEncontradoException.class, () -> gt.BorrarPiloto(tercerPiloto)); 
	}   
	
	@Test
	@DisplayName("TraerPilotoPorId")
	public void TraerPilotoPorId_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		//arrange y act
		GestorPiloto gt= new GestorPiloto();   
				
		Piloto unPiloto = new Piloto(1,"Ruiz","Alberto","2832423424");
		Piloto otroPiloto = new Piloto(2,"Perez","Juan, Fernando","272121811");
		Piloto tercerPiloto = new Piloto(3,"Macri","Franco", "2981238128");
		 			 		
		gt.getLosPilotos().add(unPiloto); 
		gt.getLosPilotos().add(otroPiloto); 
		gt.getLosPilotos().add(tercerPiloto);			 		
		 		 
 		Piloto piloto1 = gt.TraerPilotoPorId(1);
 		Piloto piloto2 = gt.TraerPilotoPorId(2);
 		Piloto piloto3 = gt.TraerPilotoPorId(3);
 			 		 			 			 		 
 		//assert 
 		assertEquals(3,gt.getLosPilotos().size());  
 		assertEquals("Juan, Fernando",piloto2.getNombres());
 		assertSame(3,piloto3.getIdPiloto()); 
 		assertEquals("2832423424", piloto1.getDocumento());
 		assertThrows(ObjetoNoEncontradoException.class, () -> gt.TraerPilotoPorId(5)); 
	}    
	
	@Test
	@DisplayName("TraerPilotoPorDocumento")
	public void TraerPilotoPorDocumento_TodosLosAtributos_InstanciasCorrectas() throws 
	ObjetoNoEncontradoException, StringNuloException, ValorNegativoException  {  
		
		GestorPiloto gt= new GestorPiloto();   
		
		Piloto unPiloto = new Piloto(1,"Ruiz","Alberto","2832423424");
		Piloto otroPiloto = new Piloto(2,"Perez","Juan, Fernando","272121811");
		Piloto tercerPiloto = new Piloto(3,"Macri","Franco", "2981238128");
		 			 		
		gt.getLosPilotos().add(unPiloto); 
		gt.getLosPilotos().add(otroPiloto); 
		gt.getLosPilotos().add(tercerPiloto);			 		
		 		 
 		Piloto piloto1 = gt.TraerPilotoPorDocumento("2832423424");
 		Piloto piloto2 = gt.TraerPilotoPorDocumento("272121811");
 		Piloto piloto3 = gt.TraerPilotoPorDocumento("2981238128");
 			 		 			 			 		
 		//assert 
 		assertEquals(3,gt.getLosPilotos().size());  
 		assertEquals("Juan, Fernando",piloto2.getNombres());
 		assertSame(3,piloto3.getIdPiloto()); 
 		assertEquals("2981238128", piloto3.getDocumento());
 		assertSame(1,piloto1.getIdPiloto());
 		assertThrows(ObjetoNoEncontradoException.class, () -> gt.TraerPilotoPorDocumento("28131367")); 
	}    
	
	

}
