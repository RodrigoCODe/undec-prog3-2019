package aeropuerto;

public class Asiento {
	
	private Integer idAsiento;
	private String numeroAsiento;
	
	public Asiento(Integer idAsiento, String numeroAsiento) {
		this.idAsiento = idAsiento;
		this.numeroAsiento = numeroAsiento; 
	}

	public Integer getIdAsiento() {
		return idAsiento;
	}

	public String getNumeroAsiento() {
		return numeroAsiento;
	}
	
	

}
