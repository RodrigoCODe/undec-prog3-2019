package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.ClienteIncompletoException;


public class Cliente {
	
	private Integer idCliente;
	private String apellido;
	private String nombres;
	private String documento;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String telefono;
	private ArrayList<Vehiculo> losVehiculos = new ArrayList<Vehiculo>();
	
	private Cliente(String apellido, String nombres, String documento, LocalDate fechaNacimiento, String domicilio,
			String telefono) {
		this.apellido = apellido;
		this.nombres = nombres;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	
	
	public static Cliente factoryCliente(Integer idCliente, String apellido, String nombres, String documento, 
			LocalDate fechaDeNacimiento, String domicilio, String telefono) throws ClienteIncompletoException {
		
			if(apellido == null || apellido == "" || nombres == null || nombres == "" || nombres == null 
				|| documento == "" || documento == null || domicilio == "" || domicilio == null ||
				telefono == null ||	telefono == "") {
					throw new ClienteIncompletoException();
			}else {

					return new Cliente(apellido, nombres, documento, fechaDeNacimiento,domicilio, telefono);
				}
								
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public String getApellido() {
		return apellido;
	}


	public String getNombres() {
		return nombres;
	}


	public String getDocumento() {
		return documento;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public String getTelefono() {
		return telefono;
	}


	public ArrayList<Vehiculo> getLosVehiculos() {
		return losVehiculos;
	}


	public void asignarVehiculo(Vehiculo elVehiculo) {
		boolean exito =false;
		if(losVehiculos.isEmpty() == true) {
			exito= true;
		}else {
			for(Vehiculo otroVehiculo : losVehiculos) {
				if(otroVehiculo.getPatente().equals(elVehiculo.getPatente())== true){
					exito=false;
				}else {
					exito=true;
				}
			}
		}
		if(exito==true) {
			losVehiculos.add(elVehiculo);
		}
		
	}


	public List<Vehiculo> devolverVehiculos() {
		
		return getLosVehiculos();
	}
	
	
	
	
	
}