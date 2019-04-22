package marroquineria;

public class Comprador {

	private String nombre;
	private String dni;
	private String apellido;
	private String tel;
	
	public Comprador(String nombre, String apellido, String dni, String tel) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tel = tel;
	}
	
	public Comprador(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
		
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public String getApellido() {
		return apellido;
	}
	public String getTel() {
		return tel;
	}
	
	
}
