package marroquineria;

import java.util.ArrayList;

public class GestorProducto {
	
	private static GestorProducto gp;

	private ArrayList<Producto> misProductos = new ArrayList<Producto>();
	
	
	public GestorProducto() {
		
		
	}
	

	public static GestorProducto getInstancia() {
		if(gp==null) { 
			gp=new GestorProducto();
			return gp;
		}else {
			return gp;
		}
	}
	
	public boolean addProducto(Producto elProducto) { 
		boolean exito=false; 
		if(misProductos.isEmpty() == false) {
			for(int i=0; i < misProductos.size() ;++i) {
				if(misProductos.get(i).getNombre().equals(elProducto.getNombre()) == true && 
						misProductos.get(i).getCodigo().equals(elProducto.getCodigo())==true) {
						exito = false; 
				}else {   
					exito = true;
				}   
			}
			if(exito==true) {
				misProductos.add(elProducto);
				
			}else {
				
			}
		}else {
			misProductos.add(elProducto);
			exito = true; 
			
		}
		
		return exito;
	}

	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}
	
	
	
		
}

