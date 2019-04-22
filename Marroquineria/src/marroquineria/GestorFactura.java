package marroquineria;

import java.util.ArrayList;

public class GestorFactura {
	
	private static GestorFactura gf;
	
	private ArrayList<Factura> misFacturas = new ArrayList<Factura>();

	public GestorFactura() {
		
	}
	
	public static GestorFactura getInstancia() {
		if(gf==null) {
			gf = new GestorFactura();
			return gf;
		}else {
			return gf;
		}
	}
	
	public boolean addFactura(Factura laFactura) { 
		misFacturas.add(laFactura);
//		
		return true;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}


	
	
	
	
	
	
	
	
	
}
