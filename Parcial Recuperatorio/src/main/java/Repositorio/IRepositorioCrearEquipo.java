package Repositorio;

import Model.Equipo;

public interface IRepositorioCrearEquipo {
	
	public boolean guardar(Equipo equipoNuevo);
	
	public Equipo findByNombre(String nombre);

}
