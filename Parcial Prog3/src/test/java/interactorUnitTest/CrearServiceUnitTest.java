package interactorUnitTest;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import Mockito.MockitoExtension;
import excepciones.ClienteIncompletoException;
import excepciones.ClienteMenorDeEdadException;
import excepciones.ExisteServiceException;
import excepciones.ServiceFechaIncorrectaException;
import excepciones.ServiceIncompletoException;
import excepciones.VehiculoIncompletoException;
import interactor.CrearServiceUseCase;
import modelo.Cliente;
import modelo.Service;
import modelo.Vehiculo;
import repositorio.IRespositorioCrearService;

@ExtendWith(MockitoExtension.class)
public class CrearServiceUnitTest {
	
 @Mock
 IRespositorioCrearService CrearServiceGateway;
 
 @Test
 public void CrearService_ServiceCorrecto_InstanciaCorrecta() throws VehiculoIncompletoException, ClienteIncompletoException, ClienteMenorDeEdadException, ServiceIncompletoException, ServiceFechaIncorrectaException, ExisteServiceException {
	Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
	Cliente elCliente = Cliente.factoryCliente(1, "Perez", "Juan", "12345678", LocalDate.of(1990, 1, 1),
				"Av. San Martin 123", "15152020");
	Service elService = Service.factoryService(1, elVehiculo, elCliente, LocalDate.of(2018, 10, 10),
			"Cambio de Aceite y Filtro", 1500.00f);
	when(CrearServiceGateway.guardar(elService)).thenReturn(true);
	CrearServiceUseCase crearServiceUseCase = new CrearServiceUseCase(CrearServiceGateway);
	boolean resultado = crearServiceUseCase.CrearService(elService);
	Assertions.assertTrue(resultado);
	
 }
 
 
 

}
