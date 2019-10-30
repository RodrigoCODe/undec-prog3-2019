package Model;

import java.time.LocalDate;


import Exceptions.JugadorIncompletoException;

public class Jugador {


    private Integer idJugador;
    private String nombre;
    private LocalDate fechaNacimiento;
    private double estatura;
    private String documento;
    
    public Jugador(Integer idJugador, String nombre, LocalDate fechaNacimiento, double estatura, String documento) {
    	this.idJugador = idJugador;
    	this.nombre = nombre;
    	this.fechaNacimiento = fechaNacimiento;
    	this.estatura = estatura;
    	this.documento = documento;
    }
    
    public static Jugador instancia(Integer idJugador, String nombre, LocalDate fechaNacimiento, 
    		double estatura, String documento) throws JugadorIncompletoException {
    	
    	if(idJugador == null || nombre == "" || fechaNacimiento == null || estatura <= 0 || documento == "") {
    		throw new JugadorIncompletoException();
    	}else {
    		return new Jugador(idJugador, nombre, fechaNacimiento, estatura, documento);
    	}
    	
   	}

	public Integer getIdJugador() {
		return idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public double getEstatura() {
		return estatura;
	}

	public String getDocumento() {
		return documento;
	}
    
    
    
    
    


}
