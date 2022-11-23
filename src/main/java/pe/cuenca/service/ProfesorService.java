package pe.cuenca.service;

import java.util.List;

import pe.cuenca.dto.ProfesorDTO;

public interface ProfesorService {
	
	List<ProfesorDTO> listar();

	ProfesorDTO obtenerId(Integer id);

	void guardar(ProfesorDTO a);

	void eliminar(Integer id);

	void actualizar(ProfesorDTO a);
	

}
