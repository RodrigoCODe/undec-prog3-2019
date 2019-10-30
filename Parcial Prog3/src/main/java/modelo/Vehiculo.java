package modelo;

import excepciones.VehiculoIncompletoException;

public class Vehiculo {
	
	private int idVehiculo;
	private String marcaModelo;
	private String patente;
	private int anio;
	
	public Vehiculo(Integer idVehiculo, String marcaModelo, String patente, int anio) {
		
		this.idVehiculo = idVehiculo;
		this.marcaModelo = marcaModelo;
		this.patente = patente;
		this.anio = anio;
	}
	
	
	public static Vehiculo factoryVehiculo(int idVehiculo, String marcaModelo, String patente, int anio) throws VehiculoIncompletoException {
		if(idVehiculo == 0 || marcaModelo == "" || marcaModelo == null || 
				patente =="" || patente== null) {
				throw new VehiculoIncompletoException();
		}else {
			return new Vehiculo(idVehiculo, marcaModelo, patente, anio);
		}
	}
 
	public int getIdVehiculo() {
		return idVehiculo;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public String getPatente() {
		return patente;
	}

	public int getAnio() {
		return anio;
	}


	public String mostrarVehiculo() {
		String devuelve;		
		return devuelve= getMarcaModelo() + " modelo "+ getAnio() +" - Patente "+ getPatente();
	}
	
	
	

}
