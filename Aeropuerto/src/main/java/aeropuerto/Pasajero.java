package aeropuerto;

public class Pasajero {
	
	private Integer idPasajero;
	private String cuil;
	private String apellido;
	private String nombres;
	private String telefono;

	public Pasajero(Integer idPasajero, String cuil, String apellido, String nombres, String telefono)
	throws StringNuloException, ValorNegativoException{  
			if(idPasajero == null) {               
				throw new NullPointerException("El id de un pasajero No puede ser Nulo");   
			}else {
				if(idPasajero <= 0) {
					throw new ValorNegativoException("El id de un pasajero no puede ser Cero o negativo");
				}else {	
					if(cuil == null || cuil == "") {        
						throw new StringNuloException("El cuil de un pasajero no puede ser Nulo"); 
					}else {
						if(apellido == null || apellido == "") {        
							throw new StringNuloException("El apellido de un pasajero no puede ser Nulo");
						}else {
							if(nombres == null || nombres == "") {
								throw new StringNuloException("Los nombres de un pasajero no pueden ser Nulos");
							}else {
								if(telefono == null) {
									throw new StringNuloException("El telefono de un pasajero no puede ser Nulo");
								}else {
									this.idPasajero = idPasajero;
									this.cuil = cuil;
									this.apellido = apellido;
									this.nombres = nombres;
									this.telefono = telefono;
								}
							}
							
						}
					}
				}
			}
		}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdPasajero() {
		return idPasajero;
	}

	public String getCuil() {
		return cuil;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombres() {
		return nombres;
	}

	
}
