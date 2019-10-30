package Interactor;

import Exceptions.JugadorExisteException;
import Model.Equipo;
import Model.Jugador;
import Repositorio.IRepositorioCrearJugador;

public class CrearJugadorUseCase {

	private IRepositorioCrearJugador irespositorioCrearJugador;
	
	public CrearJugadorUseCase(IRepositorioCrearJugador iRepositorioCrearJugador) {
		this.irespositorioCrearJugador = irespositorioCrearJugador;
	}
	
	public boolean existeJugador(Jugador elJugador) {
		return irespositorioCrearJugador.findByDocumento(elJugador.getDocumento()) != null;
	}
	
	public boolean crearJugador(Jugador elJugador) throws JugadorExisteException {
		if(existeJugador(elJugador)) {
			throw new JugadorExisteException(); 
		}else { 
		
				return this.irespositorioCrearJugador.guardar(elJugador);
			}
		}
	
		
	
}
	
	

