package marroquineria;
import java.util.ArrayList;

public class GestorComprador {
	
	private static GestorComprador gc;

	private ArrayList<Comprador> misCompradores = new ArrayList<Comprador>();
	
	
	public GestorComprador() {
				
	}
	

	public static GestorComprador getInstancia() {
		if(gc==null) { 
			gc=new GestorComprador();
			return gc;
		}else {
			return gc;
		}
	}
	
	
	public boolean addComprador(Comprador elComprador) { 
		boolean exito=false; 
		if(misCompradores.isEmpty() == false) {
			for(int i=0; i < misCompradores.size() ;++i) {
				if(misCompradores.get(i).getApellido().equals(elComprador.getApellido()) == true && 
						misCompradores.get(i).getDni().equals(elComprador.getDni())==true) {
						exito = false; 
												
				}else {   
					exito = true;
				}   
				
			}
			if(exito==true) { 
				misCompradores.add(elComprador);
				
			}else {
				
			}
		}else {
			misCompradores.add(elComprador);
			exito = true; 
			
			 
		}
		
		return exito;
	}

	public ArrayList<Comprador> getMisCompradores() {
		return misCompradores;
	}
	
	
}
