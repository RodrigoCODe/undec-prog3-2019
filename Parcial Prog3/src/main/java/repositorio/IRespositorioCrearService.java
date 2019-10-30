package repositorio;

import java.time.LocalDate;

import modelo.Service;

public interface IRespositorioCrearService {

	
	public boolean guardar(Service elService);
	
	public Service findByFecha(LocalDate fechaService);
}
