package marroquineria;

public class Cartera extends Producto{
	
	private Genero gender;
	

	public Cartera(String nombre, String codigo, Precio elPrecio,String color, String marca, Genero gender) {
		super(String nombre, String codigo, Precio elPrecio,String color, String marca, Genero gender);
		this.gender = gender;
	}


	public Genero getGender() {
		return gender;
	}

	

}
