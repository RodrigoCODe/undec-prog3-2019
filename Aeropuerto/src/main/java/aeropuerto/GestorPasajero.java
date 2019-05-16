package aeropuerto;

import java.util.ArrayList;

public class GestorPasajero {
	
	private static GestorPasajero gp;
	
	private ArrayList<Pasajero> losPasajeros = new ArrayList<Pasajero>();
	
	public GestorPasajero() {
		
	}
	
	public static GestorPasajero getInstancia() {
		if(gp==null) { 
			gp=new GestorPasajero();
			return gp;  
		}else {
			return gp; 
		} 
	}
	
	public boolean AgregarPasajero(Pasajero unPasajero) throws ObjetoDuplicadoException{ 
		boolean exito = false;
		if(losPasajeros.isEmpty() == true) {
			exito = true;
		}else {
			for(Pasajero elPasajero : losPasajeros) {
				if(elPasajero.getIdPasajero().equals(unPasajero.getIdPasajero())){
					throw new ObjetoDuplicadoException("El Pasajero ya se Encuentra cargado con ese id");
				}else { 
					exito=true;  
				}
			} 
		} 
		if(exito==true) {
		losPasajeros.add(unPasajero);
		return exito;
		}else {
			return exito;
		}
	}
	
	public boolean ActualizarTelefonoPasajero(Pasajero unPasajero, String nuevoTelefono) 
			throws ObjetoNoEncontradoException{
				
				boolean exito = false;
				for(int i=0;i<losPasajeros.size();++i) {
				
					if(losPasajeros.get(i).getIdPasajero().equals(unPasajero.getIdPasajero())) { 
						losPasajeros.get(i).setTelefono(nuevoTelefono);
						exito = true;  
						break;  
					}else {   
						exito =false; 
					}
				
				}
				if(exito == false) {
					throw new ObjetoNoEncontradoException("El Pasajero no fue Encontrado");
				}
				return exito;    
	}
	
	public boolean BorrarPasajero(Pasajero unPasajero) throws ObjetoNoEncontradoException{
		boolean exito= false;
		for(int i=0 ; i < losPasajeros.size();++i) {
			if(losPasajeros.get(i).getIdPasajero().equals(unPasajero.getIdPasajero())){
				losPasajeros.remove(unPasajero);
				exito=true;
				break;
			} else { 
				exito = false; 
			}
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Pasajero a Borrar no fue Encontrado");
		}
		return exito;    
	} 
	
	public Pasajero TraerPasajeroPorId(Integer IdPasajero) throws ObjetoNoEncontradoException{
		Pasajero pasajeroBuscado = null;
		boolean exito = false;
		for(int i=0; i<losPasajeros.size() ;++i) {
			if(losPasajeros.get(i).getIdPasajero().equals(IdPasajero)) {
				pasajeroBuscado = losPasajeros.get(i);
				exito = true;
				break;
			}else {
				exito = false;
			} 
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Pasajero Buscado por Id no fue Encontrado");
		}
		return pasajeroBuscado; 
	}
	
	public Pasajero TraerPasajeroPorCuil(String cuilPasajero) throws ObjetoNoEncontradoException{
		Pasajero pasajeroBuscado = null;
		boolean exito=false;
		for(int i=0; i<losPasajeros.size() ;++i) {
			if(losPasajeros.get(i).getCuil().equals(cuilPasajero)) {
				pasajeroBuscado = losPasajeros.get(i);
				exito=true;
				break;
			}else {
				exito = false;
			}
		}
		if(exito==false) {
			throw new ObjetoNoEncontradoException("El Pasajero Buscado por Cuil no fue Encontrado");
		}
		return pasajeroBuscado; 
	}
	
	
	public ArrayList<Pasajero> TraerPasajerosPorApellido(String apellidoPasajero) throws ObjetoNoEncontradoException{
		
		ArrayList<Pasajero> pasajerosPorApellido = new ArrayList<Pasajero>();
		
		for(int i=0; i<losPasajeros.size() ;++i) {
			if(losPasajeros.get(i).getApellido().equals(apellidoPasajero)) {
				pasajerosPorApellido.add(losPasajeros.get(i));
			} 
		}
		if(pasajerosPorApellido.isEmpty()) {
			throw new ObjetoNoEncontradoException("Los Pasajeros buscados por Apellido no se encontraron");
		}else {
			return pasajerosPorApellido;
		}
	}
	
	public ArrayList<Pasajero> getLosPasajeros(){
		return losPasajeros;
	}
	
	public ArrayList<Pasajero> traerTodosLosPasajeros(){
		return getLosPasajeros();
	}
	
	
	
	
	
	
 }
