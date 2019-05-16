package aeropuerto;

public class Piloto {

	private Integer idPiloto;
	private String apellido;
	private String nombres;
	private String documento;
	
	
	
	public Piloto(Integer idPiloto, String apellido, String nombres, String documento)
			throws StringNuloException, ValorNegativoException{  
			if(idPiloto == null) {               
				throw new NullPointerException("El id de un piloto No puede ser Nulo");   
			}else {
				if(idPiloto <= 0) {
					throw new ValorNegativoException("El id de un piloto no puede ser Cero o negativo");
				}else {	
					if(apellido == null || apellido == "") {        
						throw new StringNuloException("El apellido de un piloto no puede ser Nulo"); 
					}else {
						if(nombres == null || nombres == "") {        
							throw new StringNuloException("Los nombres de un piloto no pueden ser Nulos");
						}else {
							if(documento == null || documento == "") {
								throw new StringNuloException("Los nombres de un pasajero no pueden ser Nulos");
							}else {
									this.idPiloto = idPiloto;
									this.apellido = apellido;
									this.nombres = nombres;
									this.documento = documento;
							}
						}
					}
				}
			}
	}



	public Integer getIdPiloto() {
		return idPiloto;
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
		
	


}
