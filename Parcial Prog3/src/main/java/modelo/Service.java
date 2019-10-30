package modelo;

import java.time.LocalDate;

import excepciones.ServiceFechaIncorrectaException;
import excepciones.ServiceIncompletoException;

public class Service {
	
	private int idServicio;
	private Vehiculo elVehiculo;
	private Cliente elCliente;
	private LocalDate fechaServicio;
	private String detalle;
	private float precio;
	
	
	public Service(int idServicio, Vehiculo elVehiculo, Cliente elCliente, LocalDate fechaServicio, String detalle
			, float precio) {
		
		this.idServicio = idServicio;
		this.elVehiculo = elVehiculo;
		this.elCliente = elCliente;
		this.fechaServicio = fechaServicio;
		this.detalle = detalle;
		this.precio = precio;
	}
	
	public static Service factoryService(int idServicio, Vehiculo elVehiculo, Cliente elCliente, LocalDate fechaServicio, 
			String detalle, float precio) throws ServiceIncompletoException, ServiceFechaIncorrectaException {
		LocalDate fechaDeHoy = LocalDate.now();
		if(idServicio == 0 || elVehiculo == null || elCliente== null) {
			throw new ServiceIncompletoException();
		}else {
			if(fechaServicio.isAfter(fechaDeHoy)) {
				throw new ServiceFechaIncorrectaException();
			}else {
				return new Service(idServicio, elVehiculo, elCliente, fechaServicio, detalle, precio);
			}
			
		}
		
	}


	public int getIdServicio() {
		return idServicio;
	}

	public Vehiculo getElVehiculo() {
		return elVehiculo;
	}

	public Cliente getElCliente() {
		return elCliente;
	}

	public LocalDate getFechaServicio() {
		return fechaServicio;
	}

	public String getDetalle() {
		return detalle;
	}

	public float getPrecio() {
		return precio;
	}

	public String mostrarResumen() {
		String devuelve;
		return 
		devuelve =		
		"Service Nro: "+ getIdServicio() + 
		"\nCliente: " + elCliente.getApellido()+", "+elCliente.getNombres()+" - "+elCliente.getTelefono()
		+"\nVehiculo: "+ elVehiculo.getMarcaModelo() + " modelo "+ elVehiculo.getAnio()+ " - Patente "+
		elVehiculo.getPatente()
		+ "\nTrabajo Realizado: "+ getDetalle();
		
	}
	
	
	
	
	
	
	

}
