package interactorUnitTest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import Mockito.MockitoExtension;
import excepciones.VehiculoExisteException;
import excepciones.VehiculoIncompletoException;
import interactor.CrearVehiculoUseCase;
import modelo.Vehiculo;
import repositorio.IRepositorioCrearVehiculo;

@ExtendWith(MockitoExtension.class)
public class CrearVehiculoUnitTest {
	
	@Mock
	IRepositorioCrearVehiculo CrearVehiculoGateway;
	
	@Test
	public void CrearVehiculo_VehiculoNoExiste_GuardadoCorrecto() throws VehiculoIncompletoException, VehiculoExisteException {
		Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
		when(CrearVehiculoGateway.guardar(elVehiculo)).thenReturn(true);
		CrearVehiculoUseCase crearVehiculoUse = new CrearVehiculoUseCase(CrearVehiculoGateway);
		boolean resultado = crearVehiculoUse.crearVehiculo(elVehiculo);
		Assertions.assertTrue(resultado);
	}
	
	@Test
	public void CrearVehiculo_VehiculoExiste_VehiculoExisteException() throws VehiculoIncompletoException {
		Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "Renautl", "IVD979", 2010);
		when(CrearVehiculoGateway.findByPatente("IVD979")).thenReturn(Vehiculo.factoryVehiculo(2, "VW", "IVD979", 2015));
		CrearVehiculoUseCase crearVehiculoUseCase = new CrearVehiculoUseCase(CrearVehiculoGateway);
		Assertions.assertThrows(VehiculoExisteException.class, () -> crearVehiculoUseCase.crearVehiculo(elVehiculo));
		
	}

}
