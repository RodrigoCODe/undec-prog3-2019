package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import excepciones.ClienteIncompletoException;
import excepciones.ClienteMenorDeEdadException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Vehiculo;

class ClienteUnitTest {

	
	@Test
	void instanciarCliente_ClienteCompleto_instanciaCorrecta() throws ClienteIncompletoException, ClienteMenorDeEdadException {
		Cliente elCliente=Cliente.factoryCliente(1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020");
		assertNotNull(elCliente);		
	}
	
	@Test
	void instanciarCliente_ClienteSinDocumento_ClienteIncompletoException() {
		Assertions.assertThrows(ClienteIncompletoException.class, ()-> Cliente.factoryCliente(1,"Perez", "Juan",null,LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020"));	
	}
	
	@Test 
	void instanciarCliente_menorDeEdad_ClienteMenorDeEdadException() {
		Assertions.assertThrows(ClienteMenorDeEdadException.class, ()-> Cliente.factoryCliente(1,"Suarez", "Gabriel","28131322",LocalDate.of(2015, 1, 1) , "Av. San Martin 123", "15152020"));
	}
	
	@Test
	void asignarVehiculo_vehiculoCompleto_asignacionExitosa() throws ClienteIncompletoException, VehiculoIncompletoException, ClienteMenorDeEdadException {
		Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
		Cliente elCliente=Cliente.factoryCliente(1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020");
		elCliente.asignarVehiculo(elVehiculo);
		assertEquals(1, elCliente.devolverVehiculos().size());
		
	}
	
	@Test
	void devolverVehiculos_clienteConVehiculos_coleccionConDatos() throws ClienteIncompletoException, VehiculoIncompletoException, ClienteMenorDeEdadException {
		Vehiculo vwGolf= Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
		Vehiculo toyotaCorolla= Vehiculo.factoryVehiculo(1, "Toyota Corolla", "XYZ890", 2009);
		Cliente elCliente=Cliente.factoryCliente(1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020");
		elCliente.asignarVehiculo(vwGolf);
		elCliente.asignarVehiculo(toyotaCorolla);
		
		List<Vehiculo> losVehiculos=elCliente.devolverVehiculos();
		
		assertEquals(2, losVehiculos.size());
		
	}
	
	@Test
	void devolverVehiculos_clienteSinVehiculos_coleccionSinDatos() throws ClienteIncompletoException, ClienteMenorDeEdadException {
		Cliente elCliente=Cliente.factoryCliente(1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020");
		
		List<Vehiculo> losVehiculos=elCliente.devolverVehiculos();

		assertEquals(0, losVehiculos.size());
		
	}
	
	@Test
	public void mostrarDatosCliente_FormateEspecifico() throws ClienteIncompletoException, ClienteMenorDeEdadException {
		Cliente elCliente=Cliente.factoryCliente(1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020");
		String formatoSalida = elCliente.mostrarDatosCliente();
		Assertions.assertEquals("Perez, Juan - 15152020", formatoSalida);
	}
	

}
