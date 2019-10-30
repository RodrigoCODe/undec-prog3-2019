package repositorio;

import modelo.Vehiculo;

public interface IRepositorioCrearVehiculo {
	
	public boolean guardar(Vehiculo elVehiculo);
	
	public Vehiculo findByPatente(String patente);

}
