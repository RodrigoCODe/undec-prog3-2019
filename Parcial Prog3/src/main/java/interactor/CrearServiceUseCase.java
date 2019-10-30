package interactor;

import excepciones.ExisteServiceException;
import modelo.Service;
import repositorio.IRespositorioCrearService;

public class CrearServiceUseCase {
	
	private IRespositorioCrearService CrearServiceGateway;
	
	public CrearServiceUseCase(IRespositorioCrearService CrearServiceGateway) {
		this.CrearServiceGateway = CrearServiceGateway;
	}
	
	public boolean CrearService(Service elService) throws ExisteServiceException {
		if(ExisteService(elService)) {
			throw new ExisteServiceException();
		}else {
			return this.CrearServiceGateway.guardar(elService);
		}
		
	}
	
	public boolean ExisteService(Service elService) {
		return CrearServiceGateway.findByFecha(elService.getFechaServicio()) != null;
	}
	
	

}
