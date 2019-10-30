package Interactor;


import Exceptions.EquipoExisteException;
import Model.Equipo;
import Repositorio.IRepositorioCrearEquipo;

public class CrearEquipoUseCase {

	private IRepositorioCrearEquipo iRepositorioCrearEquipo;
	
	
	
	public CrearEquipoUseCase(IRepositorioCrearEquipo iRepositorioCrearEquipo) {
		this.iRepositorioCrearEquipo = iRepositorioCrearEquipo;
	}

	public boolean existeEquipo(Equipo elEquipo) {
		return iRepositorioCrearEquipo.findByNombre(elEquipo.getNombre())!= null; 
				
	}
	
	
	public boolean crearEquipo(Equipo equipoNuevo) throws EquipoExisteException {
		if(existeEquipo(equipoNuevo)) {
			throw new EquipoExisteException(); 
		}else {
			return this.iRepositorioCrearEquipo.guardar(equipoNuevo);
		}
	
	}
	
	
}
