package marroquineria;

import java.util.ArrayList;

public abstract class Producto {

	private final String nombre;
	private final String codigo;
	private final String color;
	private final String marca;

	private final List<Precio> losPrecios = new ArrayList<Precio>();

	
	
	public Producto(String nombre,String codigo, Precio elPrecio,String color, String marca) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.color = color;
		this.marca = marca;
		this.losPrecios.add(elPrecio);
		
	}
		
	
	public ArrayList<Precio> getLosPrecios() {
		return losPrecios;
	}

	public String getNombre() {
		return nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public String getColor() {
		return color;
	}


	public String getMarca() {
		return marca;
	}

	
	
}
