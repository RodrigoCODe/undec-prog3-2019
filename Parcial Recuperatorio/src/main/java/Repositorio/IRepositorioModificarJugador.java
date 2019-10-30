package Repositorio;

import Model.Jugador;

public interface IRepositorioModificarJugador {

	public Jugador findByDNI(String documento);

	public boolean actualizar(Jugador messiDatosNuevos);
	

}
