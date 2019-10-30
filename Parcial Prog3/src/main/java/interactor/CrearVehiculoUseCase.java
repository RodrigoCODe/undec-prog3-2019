package interactor;

import excepciones.VehiculoExisteException;
import modelo.Vehiculo;
import repositorio.IRepositorioCrearVehiculo;

public class CrearVehiculoUseCase {
	
	private IRepositorioCrearVehiculo CrearVehiculoGateway;
	
	public CrearVehiculoUseCase(IRepositorioCrearVehiculo CrearVehiculoGateWay) {
		this.CrearVehiculoGateway = CrearVehiculoGateWay;
	}
	
	public boolean existeVehiculo(Vehiculo elVehiculo) {
		return CrearVehiculoGateway.findByPatente(elVehiculo.getPatente()) != null;
	}
	
	public boolean crearVehiculo(Vehiculo vehiculoNuevo) throws VehiculoExisteException {
		if(existeVehiculo(vehiculoNuevo)) {
			throw new VehiculoExisteException();
		}else {
			return this.CrearVehiculoGateway.guardar(vehiculoNuevo);
		}
	}

}
