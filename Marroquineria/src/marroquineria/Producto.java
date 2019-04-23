package marroquineria;

import java.util.ArrayList;

public abstract class Producto {

	private String nombre;
	private String codigo;

	private List<Precio> losPrecios = new ArrayList<Precio>();

	
	
	public Producto(String nombre,String codigo, Precio elPrecio) {
		this.nombre = nombre;
		this.codigo = codigo;
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

	
	
	
}
