package repositorio;

import modelo.Cliente;

public interface IRepositorioCrearCliente {

	public boolean guardar(Cliente clienteNuevo);

	public Cliente findByDNI(String dniCliente);
}
