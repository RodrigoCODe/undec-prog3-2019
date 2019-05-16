package aeropuerto;

import java.util.ArrayList;

public class Avion {

	private Integer idAvion; 
	private String modelo;
	private String matricula;
	private ArrayList<Asiento> losAsientos = new ArrayList<Asiento>(); 
	 
	public Avion(Integer idAvion, String modelo, String matricula) throws 
	StringNuloException, ValorNegativoException, NullPointerException{   
		if(idAvion == null) {               
			throw new NullPointerException("El id de un Avion No puede ser Nulo");   
		}else {
			if(idAvion <= 0) {
				throw new ValorNegativoException("El id de un Avion no puede ser Cero o negativo");
			}else {			 
				if(modelo == null || modelo == "") {        
					throw new StringNuloException("El modelo de un Avion no puede ser Nulo"); 
				}else {
					if(matricula == null || matricula == "") {        
						throw new StringNuloException("La matricula de un Avion no puede ser Nulo");
					}else {		
						this.idAvion = idAvion; 
						this.modelo = modelo; 
						this.matricula = matricula; 
						crearAsientos(); 
					}
				}
			}
		}
	} 
	
	public ArrayList<Asiento> crearAsientos() {
		for(Integer i=0; i < 23 ; ++i) {
			losAsientos.add(new Asiento(i,i.toString()));
		}
		return losAsientos; 
	}

	public Integer getIdAvion() {
		return idAvion;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public ArrayList<Asiento> getLosAsientos() {
		return losAsientos;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
		
	}
	
	
	

	

}
