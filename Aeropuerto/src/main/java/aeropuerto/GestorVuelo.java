package aeropuerto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestorVuelo {
	
	private static GestorVuelo gv;
	
	public ArrayList<Vuelo> losVuelos = new ArrayList<Vuelo>();
	
	public GestorVuelo() {
		
	}
	
	public static GestorVuelo getInstancia() {
		if(gv==null) { 
			gv=new GestorVuelo();
			return gv;  
		}else {
			return gv; 
		}  
	} 
	
	public boolean AgregarVuelo(Vuelo unVuelo) throws ObjetoNoEncontradoException{ 
		boolean exito = false;
		if(losVuelos.isEmpty() == true) {
			exito = true;
		}else {
			for(Vuelo elVuelo : losVuelos) {
				if(elVuelo.getCodigoVuelo().equals(unVuelo.getCodigoVuelo())){
					exito=true;
					break;
				}else { 
					exito=false;  
				}
			} 
		}
		if(exito==true) {
		losVuelos.add(unVuelo);
		
		
		}else {
			throw new ObjetoNoEncontradoException("El vuelo no fue encontrado");
			
		}
		return exito;
	}
	
	public boolean DemorarVuelo(Vuelo unVuelo, LocalDateTime fechaHoraNueva  ) 
			throws ObjetoNoEncontradoException, FechaIncorrectaException{
				
				boolean exito = false;
				for(int i=0;i<losVuelos.size();++i) {
				
					if(losVuelos.get(i).getCodigoVuelo().equals(unVuelo.getCodigoVuelo())) { 
						if(losVuelos.get(i).getFechaHoraSalida().isAfter(fechaHoraNueva)) {
							losVuelos.get(i).setFechaHoraSalida(fechaHoraNueva);
							exito = true;  
							break;
						}else {
							throw new FechaIncorrectaException("La Fecha Nueva es incorrecta");
						}
						
						  
					}else {   
						exito =false; 
					}
				
				}
				if(exito == false) {
					throw new ObjetoNoEncontradoException("El Avion no Fue Encontrado");
				}
				return exito;    
	}
	
	public boolean CancelarVuelo(Vuelo unVuelo) throws ObjetoNoEncontradoException{
		boolean exito= false;
		for(int i=0 ; i < losVuelos.size();++i) {
			if(losVuelos.get(i).getCodigoVuelo().equals(unVuelo.getCodigoVuelo())){
				losVuelos.remove(unVuelo);
				exito=true;
				break;
			} else { 
				exito = false;
			}
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Vuelo a Cancelar no fue Encontrado");
		}
		return exito;    
	} 

	public ArrayList<Vuelo> getLosVuelos() {
		return losVuelos;
	}    
	
	
	
	

}
