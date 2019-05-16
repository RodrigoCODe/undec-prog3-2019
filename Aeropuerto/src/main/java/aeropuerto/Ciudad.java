package aeropuerto;

public class Ciudad {

	private Integer idCiudad;
	private String nombre;
	private String codigoPostal;
	
	public Ciudad(Integer idCiudad, String nombre, String codigoPostal) throws 
	StringNuloException, ValorNegativoException, NullPointerException{
		if(idCiudad == null) {               
			throw new NullPointerException("El idCiudad No puede ser Nulo");  
		}else {
			if(idCiudad <= 0) {
				throw new ValorNegativoException("El id de una Ciudad no puede ser Cero o negativo");
			}else {			
				if(nombre == null || nombre.equals("")) {        
					throw new StringNuloException("El Nombre no puede ser Nulo"); 
					 
				}else{     
					if(codigoPostal == null || codigoPostal.equals("")) {  
							throw new StringNuloException("El Codigo Postal no puede ser Nulo"); 
						}else {
							this.idCiudad = idCiudad; 
							this.nombre = nombre;
							this.codigoPostal = codigoPostal;
						}
				}
			}
		}
	}
 
	public Integer getIdCiudad() {
		return this.idCiudad; 
	}

	public String getNombre() {
		return this.nombre;
	}

	public Object getCodigoPostal() { 
		return this.codigoPostal;
	}

}
