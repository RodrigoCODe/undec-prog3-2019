package Repositorio;

import Model.Jugador;

public interface IRepositorioCrearJugador {

	public Jugador findByDocumento(String documento);

	public boolean guardar(Jugador elJugador);

	
	
}
