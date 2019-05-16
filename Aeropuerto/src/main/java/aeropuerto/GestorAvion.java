package aeropuerto;

import java.util.ArrayList;

public class GestorAvion {

	private static GestorAvion gv;
	
	private ArrayList<Avion> losAviones = new ArrayList<Avion>();
	 
	public GestorAvion() {
		
	}
	
	public static GestorAvion getInstancia() {
		if(gv==null) { 
			gv=new GestorAvion();
			return gv;  
		}else {
			return gv; 
		} 
	} 
  
	public boolean AgregarAvion(Avion unAvion) throws ObjetoNoEncontradoException{ 
		boolean exito = false;
		if(losAviones.isEmpty() == true) {
			exito = true;
		}else {
			for(Avion elAvion : losAviones) {
				if(elAvion.getIdAvion().equals(unAvion.getIdAvion())){
					throw new ObjetoNoEncontradoException("El Avion ya se Encuentra cargado con ese id");
				}else { 
					exito=true;  
				}
			} 
		}
		if(exito==true) {
		losAviones.add(unAvion);
		return exito;
		}else {
			return exito;
		}
	}

	public boolean ActualizarMatriculaAvion(Avion unAvion, String matriculaNuevaAvion) 
	throws ObjetoNoEncontradoException{
		
		boolean exito = false;
		for(int i=0;i<losAviones.size();++i) {
		
			if(losAviones.get(i).getIdAvion().equals(unAvion.getIdAvion())) { 
				losAviones.get(i).setMatricula(matriculaNuevaAvion);
				exito = true;  
				break;  
			}else {   
				exito =false; 
			}
		
		}
		if(exito == false) {
			throw new ObjetoNoEncontradoException("El Avion no Fue Encontrado");
		}
		return exito;    
	}

	public boolean BorrarAvion(Avion unAvion) throws ObjetoNoEncontradoException{
		boolean exito= false;
		for(int i=0 ; i < losAviones.size();++i) {
			if(losAviones.get(i).getIdAvion().equals(unAvion.getIdAvion())){
				losAviones.remove(unAvion);
				exito=true;
				break;
			} else { 
				exito = false;
			}
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Avion a Borrar no fue Encontrado");
		}
		return exito;    
	}    
	
	public Avion TraerAvionPorMatricula(String matriculaAvion) throws ObjetoNoEncontradoException{
		Avion avionBuscado = null;
		boolean exito=false;
		for(int i=0; i<losAviones.size() ;++i) {
			if(losAviones.get(i).getMatricula().equals(matriculaAvion)) {
				avionBuscado = losAviones.get(i);
				exito=true;
				break;
			}else {
				exito = false;
			}
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Avion Buscado por Matricula no fue Encontrado");
		}
		return avionBuscado; 
	}
	 
	public Avion TraerAvionPorIdAvion(Integer IdAvion) throws ObjetoNoEncontradoException{
		Avion avionBuscado = null;
		boolean exito = false;
		for(int i=0; i<losAviones.size() ;++i) {
			if(losAviones.get(i).getIdAvion().equals(IdAvion)) {
				avionBuscado = losAviones.get(i);
				exito = true;
				break;
			}else {
				exito = false;
			} 
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Avion a Buscado por Id no fue Encontrado");
		}
		return avionBuscado; 
	}
	
	public ArrayList<Avion> TraerAvionesPorModelo(String modeloAvion) throws ObjetoNoEncontradoException{
		ArrayList<Avion> avionesPorModelo = new ArrayList<Avion>();
		
		for(int i=0; i<losAviones.size() ;++i) {
			if(losAviones.get(i).getModelo().equals(modeloAvion)) {
				avionesPorModelo.add(losAviones.get(i));
			} 
		}
		if(avionesPorModelo.isEmpty()) {
			throw new ObjetoNoEncontradoException("Los Aviones buscados por Modelo no se encontraron");
		}else {
			return avionesPorModelo;
		}
	}
	
	

	public ArrayList<Avion> getLosAviones() {
		return losAviones;
	} 

	public ArrayList<Avion> TraerTodosLosAviones() {
		return getLosAviones();
	}

	
}
