package marroquineria;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Factura {
	
	private Comprador comprador;
	private ArrayList<Detalle> losDetalles; 
	private GregorianCalendar fecha = new GregorianCalendar();
	
	private int anio = getFecha().get(GregorianCalendar.YEAR);
	private int mes = getFecha().get(GregorianCalendar.MONTH);
	private int dia = getFecha().get(GregorianCalendar.DAY_OF_MONTH);
	 
	public Factura(Comprador comprador) {
		this.comprador = comprador; 
		losDetalles = new ArrayList<Detalle>(); 
		this.fecha.getTime(); 
		 
	}
	
	public Comprador getComprador() {
		return comprador;
	}
	
	public GregorianCalendar getFecha() {
		return (GregorianCalendar) GregorianCalendar.getInstance();
	} 
	
	
	@Override
	public String toString() {
		return  dia+"/"+mes+"/"+anio; 
	}
		
	
	
	public ArrayList<Detalle> getLosDetalles() {
		return losDetalles;
	}

	public boolean addDetalle(Detalle elDetalle) {
		losDetalles.add(elDetalle);
		return true;
	}
	
}
