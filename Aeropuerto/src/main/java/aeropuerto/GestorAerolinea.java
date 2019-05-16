package aeropuerto;

import java.util.ArrayList;

public class GestorAerolinea {
	
	private static GestorAerolinea ga;
	
	private ArrayList<Aerolinea> lasAerolineas = new ArrayList<Aerolinea>();
	 
	public GestorAerolinea() {
		
	}
	 
	public static GestorAerolinea getInstancia() {
		if(ga==null) { 
			ga=new GestorAerolinea();
			return ga;  
		}else {
			return ga; 
		} 
	} 
 
	public boolean AgregarAerolinea(Aerolinea unaAerolinea) { 
		boolean exito = false;
		if(lasAerolineas.isEmpty() == true) {
			exito = true;
		}else {
			for(Aerolinea laAerolinea : lasAerolineas) {
				if(laAerolinea.getId().equals(unaAerolinea.getId())
						|| laAerolinea.getNombre().equals(unaAerolinea.getNombre())){
					exito=false; 
					break; 
				}else { 
					exito=true;
				}
			}
		}
		if(exito==true) {
		lasAerolineas.add(unaAerolinea);
		return exito;
		}
		else {
			return exito;
		}
	}

	public boolean ActualizarNombreAerolinea(Aerolinea unaAerolinea, String nombreNuevoAerolinea) {
		boolean exito = false;
		for(Aerolinea laAerolinea : lasAerolineas) {
			if(laAerolinea.getNombre().equals(unaAerolinea.getNombre())) { 
				laAerolinea.setNombre(nombreNuevoAerolinea);
				exito = true;  
			}
		}
		return exito;    
	}

	public boolean BorrarAerolinea(Aerolinea unaAerolinea) {
		boolean exito= false;
		for(int i=0 ; i < lasAerolineas.size();++i) {
			if(lasAerolineas.get(i).getId().equals(unaAerolinea.getId())){
				lasAerolineas.remove(unaAerolinea);
				exito=true; 
			} 
		}
		return exito;    
	}    
	
	public Aerolinea TraerUnaAerolineaPorNombre(String nombreAerolinea) throws StringNuloException, ValorNegativoException {
		Aerolinea esaAerolinea = null; 
		for(int i=0; i<lasAerolineas.size() ;++i) {
			if(lasAerolineas.get(i).getNombre().equals(nombreAerolinea)) {
				
				esaAerolinea = lasAerolineas.get(i);   
				break; 
			}
		}
		return esaAerolinea;
	}
	
	

	public ArrayList<Aerolinea> getLasAerolineas() {
		return lasAerolineas;
	} 

	public ArrayList<Aerolinea> TraerTodasLasAerolineas() {
		return getLasAerolineas();
	}

	public Aerolinea TraerUnaAerolineaPorId(Integer idAerolinea) throws StringNuloException, ValorNegativoException {
		Aerolinea esaAerolinea = null;
		for(int i=0; i<lasAerolineas.size() ;++i) { 
			if(lasAerolineas.get(i).getId().equals(idAerolinea)) { 
				
				esaAerolinea = lasAerolineas.get(i);  
				break;
			}
		} 
		return esaAerolinea;
	}
	
	 
	
	
	
	
 
}
