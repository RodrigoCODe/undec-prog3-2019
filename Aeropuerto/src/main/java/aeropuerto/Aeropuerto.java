package aeropuerto;

public class Aeropuerto {
	
	private Integer idAeropuerto;
	private String nombre;
	private String codigo;
	private Ciudad laCiudad;

	public Aeropuerto(Integer idAeropuerto, String nombre, String codigo, Ciudad laCiudad) 
	throws ValorNegativoException, StringNuloException, ObjetoNoEncontradoException{
		if(idAeropuerto == null) {               
			throw new NullPointerException("El id de Aeropuerto No puede ser Nulo");  
		}else {
			if(idAeropuerto <= 0) {
				throw new ValorNegativoException("El id de Aeropuerto no puede ser Cero o negativo");
			}else {			
				if(nombre == null || nombre.equals("")) {        
					throw new StringNuloException("El Nombre de Aeropuerto no puede ser Nulo"); 
					 
				}else{    
					if(codigo == null || codigo.equals("")) {  
							throw new StringNuloException("El Codigo de Aeropuerto no puede ser Nulo"); 
						}else { 
							if(laCiudad == null) {  
								throw new ObjetoNoEncontradoException("La Ciudad no se encuentra");
							}else {
								this.idAeropuerto= idAeropuerto;
								this.nombre = nombre;
								this.codigo = codigo;
								this.laCiudad = laCiudad;
							} 
													
						}
				}
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdAeropuerto() {
		return idAeropuerto;
	}

	public String getCodigo() {
		return codigo;
	}

	public Ciudad getLaCiudad() {
		return laCiudad;
	}
	
	

}
