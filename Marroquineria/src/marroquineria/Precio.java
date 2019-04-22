package marroquineria;


import java.util.GregorianCalendar;


public class Precio {
	 
	private int anio = getFecha().get(GregorianCalendar.YEAR);
	private int mes = getFecha().get(GregorianCalendar.MONTH);
	private int dia = getFecha().get(GregorianCalendar.DAY_OF_MONTH);
	
	private double valor;
	private GregorianCalendar fecha = new GregorianCalendar();
	
		
	public Precio(double valor) {
		this.valor = valor;
		this.fecha.getTime();
	}
 
	public GregorianCalendar getFecha() {
		return (GregorianCalendar) GregorianCalendar.getInstance();
	} 


	public double getValor() { 
		return valor;
	}

	@Override
	public String toString() {
		return  dia+"/"+mes+"/"+anio; 
	}
	
}



	
	


