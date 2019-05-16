package aeropuerto;

public class Asignacion {
	
	private String codigoAsignacion;
	private Pasajero elPasajero;
	private Asiento elAsiento;

	public Asignacion(String codigoAsignacion, Pasajero elPasajero, Asiento elAsiento)
			throws 	StringNuloException, ObjetoNoEncontradoException{   
				if(codigoAsignacion == null || codigoAsignacion == "") {        
					throw new StringNuloException("La Asignacion no puede ser Nula"); 
				}else {
					if(elPasajero == null) {        
						throw new ObjetoNoEncontradoException("El pasajero no Fue encontrado");
					}else {		
						if(elAsiento == null) {
							throw new ObjetoNoEncontradoException("El Asiento no Fue encontrado");
						}else {
							this.codigoAsignacion = codigoAsignacion; 
							this.elPasajero = elPasajero; 
							this.elAsiento = elAsiento; 
						}
					}
				}
	}

	public String getCodigoAsignacion() {
		return codigoAsignacion;
	}

	public Pasajero getElPasajero() {
		return elPasajero;
	}

	public Asiento getElAsiento() {
		return elAsiento;
	}
	
	
	
	
	

}
