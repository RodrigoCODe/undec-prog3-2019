package Interactor;

import Model.Jugador;

public class ModificarJugadorUseCase {
	
	private IRepositorioModificarJugador irepositorioModificarJugador;

	public ModificarJugadorUseCase(IRepositorioModificarJugador irepositorioModificarJugador) {
		
		this.irepositorioModificarJugador = irepositorioModificarJugador;
	}
	
	public boolean existeJugador(Jugador elJugador) {
		return irepositorioModificarJugador.findByDNI(elJugador.getDocumento()) != null;
	}
	
	public boolean modificarJugador(Jugador nuevoJugador) {
		if(existeJugador(nuevoJugador)) {
			return nuevoJugador != null;
		
	}else {
		return false;
	}
	}

}
