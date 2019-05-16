package aeropuerto;

import java.util.ArrayList;

public class GestorPiloto {
	
	private static GestorPiloto gt;
	
	private ArrayList<Piloto> losPilotos = new ArrayList<Piloto>();
	
	public GestorPiloto() {
		
	}
	
	public static GestorPiloto getInstancia() {
		if(gt==null) { 
			gt=new GestorPiloto();
			return gt;  
		}else {
			return gt; 
		} 
	}
	
	public boolean AgregarPiloto(Piloto unPiloto) throws ObjetoDuplicadoException{ 
		boolean exito = false;
		if(losPilotos.isEmpty() == true) {
			exito = true;
		}else {
			for(Piloto elPiloto : losPilotos) {
				if(elPiloto.getIdPiloto().equals(unPiloto.getIdPiloto())){
					throw new ObjetoDuplicadoException("El Piloto ya se Encuentra cargado con ese id");
				}else { 
					exito=true;  
				}
			} 
		} 
		if(exito==true) {
		losPilotos.add(unPiloto);
		return exito;
		}else {
			return exito;
		}
	}
	
	public boolean BorrarPiloto(Piloto unPiloto) throws ObjetoNoEncontradoException{
		boolean exito= false;
		for(int i=0 ; i < losPilotos.size();++i) {
			if(losPilotos.get(i).getIdPiloto().equals(unPiloto.getIdPiloto())){
				losPilotos.remove(unPiloto);
				exito=true;
				break;
			} else { 
				exito = false; 
			}
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Piloto a Borrar no fue Encontrado");
		}
		return exito;    
	} 
	
	public Piloto TraerPilotoPorId(Integer IdPiloto) throws ObjetoNoEncontradoException{
		Piloto pilotoBuscado = null;
		boolean exito = false;
		for(int i=0; i<losPilotos.size() ;++i) {
			if(losPilotos.get(i).getIdPiloto().equals(IdPiloto)) {
				pilotoBuscado = losPilotos.get(i);
				exito = true;
				break;
			}else {
				exito = false;
			} 
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Piloto Buscado por Id no fue Encontrado");
		}
		return pilotoBuscado; 
	}
	
	public Piloto TraerPilotoPorDocumento(String documentoPiloto) throws ObjetoNoEncontradoException{
		Piloto pilotoBuscado = null;
		boolean exito=false;
		for(int i=0; i<losPilotos.size() ;++i) {
			if(losPilotos.get(i).getDocumento().equals(documentoPiloto)) {
				pilotoBuscado = losPilotos.get(i);
				exito=true;
				break;
			}else {
				exito = false;
			}
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Piloto Buscado por Documento no fue Encontrado");
		}
		return pilotoBuscado; 
	}
	
	public ArrayList<Piloto> getLosPilotos(){
		return losPilotos;
	}
	
	public ArrayList<Piloto> traerTodosLosPilotos(){
		return getLosPilotos();
	}
	
	

}
