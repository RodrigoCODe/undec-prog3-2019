package marroquineria;

public class Zapato extends Producto{

	private Genero gender;
	
	
	public Zapato(String nombre, String codigo, Precio elPrecio, String color, String marca,Genero gender) {
		super(nombre, codigo, elPrecio, color, marca);
		this.gender = gender;
	}

	public Genero getGender() {
		return gender;
	}

	
}
