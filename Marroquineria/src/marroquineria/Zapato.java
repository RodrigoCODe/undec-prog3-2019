package marroquineria;

public class Zapato extends Producto{

	private String color;
	private String marca;
	private Genero gender;
	
	
	public Zapato(String nombre, String codigo, Precio elPrecio, String color, String marca,Genero gender) {
		super(nombre, codigo, elPrecio);
		this.color = color;
		this.marca = marca;
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Genero getGender() {
		return gender;
	}

	
}
