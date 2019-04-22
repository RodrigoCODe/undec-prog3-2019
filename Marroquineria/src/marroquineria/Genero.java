package marroquineria;

public enum Genero {
	M("Masculino"),
	F("Femenino"),
	U("Unisex");
	
	private final String gender;
	
	private Genero(String gender) {
		this.gender = gender;
	}


public String getGender() {
	return this.gender;
}

public String getLargo() {
	return this.gender;
}

}
