package aeropuerto;

public class Aerolinea {

	private String nombre;
	private Integer id; 

	public Aerolinea(Integer id, String nombre) throws StringNuloException, ValorNegativoException, NullPointerException{
	if(id == null) {              
			throw new NullPointerException("El id No puede ser Nulo");   
		}else {
			if(id <= 0) {
				throw new ValorNegativoException("El id de una Aerolinea no puede ser Cero o negativo");
			}else {			
				if(nombre == null ) {        
					throw new StringNuloException("El Nombre no puede ser Nulo"); 
					
				}else {
					this.id = id;   
					this.nombre = nombre; 
				}
			}
		}
	}
	
	public String getNombre() {
		
		return this.nombre;
	} 
	
	public Integer getId() {  
		return this.id; 
	}

	public void setNombre(String nombreNuevoAerolinea) {
		this.nombre = nombreNuevoAerolinea; 
		
	}
	
	

}
