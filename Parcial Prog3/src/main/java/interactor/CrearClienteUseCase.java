package interactor;

import java.time.LocalDate;

import excepciones.ClienteExisteException;
import excepciones.ClienteMenorDeEdadException;
import modelo.Cliente;
import repositorio.IRepositorioCrearCliente;

public class CrearClienteUseCase {

	private IRepositorioCrearCliente crearClienteGateway;

	public CrearClienteUseCase(IRepositorioCrearCliente crearClienteGateway) {
	
		this.crearClienteGateway = crearClienteGateway;
	}
	
	public boolean existeCliente(Cliente elCliente) {
		return crearClienteGateway.findByDNI(elCliente.getDocumento()) != null;
	}

	public boolean crearCliente(Cliente clienteNuevo) throws ClienteExisteException, ClienteMenorDeEdadException {
		LocalDate fechaHoy = LocalDate.now();
		if(existeCliente(clienteNuevo)) {
			throw new ClienteExisteException(); 
		}else { 
			if(fechaHoy.getYear() - clienteNuevo.getFechaNacimiento().getYear()<= 17) {
				throw new ClienteMenorDeEdadException();
			}else {
				return this.crearClienteGateway.guardar(clienteNuevo);
			}
		}
	}
	
}
