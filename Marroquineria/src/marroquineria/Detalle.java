package marroquineria;

public class Detalle {
	
	private Producto producto;
	private int cantidad;
	
	public Detalle(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	
	

}
