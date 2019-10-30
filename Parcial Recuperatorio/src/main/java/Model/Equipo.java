package Model;



import java.util.ArrayList;
import java.util.Collection;

import Exceptions.EquipoIncompletoException;


public class Equipo {

    private Integer idEquipo;
    private String nombre;
    private Collection<Jugador> jugadores;
    
    public Equipo(Integer idEquipo, String nombre) {
    	this.idEquipo = idEquipo;
    	this.nombre = nombre;
    	this.jugadores = new ArrayList<Jugador>();
    }
    
    public static Equipo instancia(Integer idEquipo, String nombre, ArrayList<Jugador> jugadores) throws EquipoIncompletoException {
    	if(nombre == "") {
    		throw new EquipoIncompletoException();
    	}else {
    		return new Equipo(idEquipo, nombre);
    	}
    }

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public Collection<Jugador> getJugadores() {
		return jugadores;
	}
	
	public boolean asignarJugador(Jugador elJugador) {
		boolean exito =false;
		if(jugadores.isEmpty() == true) {
			exito= true;
		
		}else {
			for(Jugador otroJugador : jugadores) {
				if(otroJugador.getDocumento().equals(elJugador.getDocumento())== true ){
					exito=false;
				}else {
					exito=true;
				}
			}
		}
		if(exito==true) {
			jugadores.add(elJugador);
			return true;
			
		}else {
			return false;
		}
	
		
	} 

    
    

}
