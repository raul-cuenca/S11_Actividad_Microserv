package pe.cuenca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cuenca.dto.ProfesorDTO;
import pe.cuenca.model.Profesor;
import pe.cuenca.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repository;

	@Override
	public List<ProfesorDTO> listar() {

		List<ProfesorDTO> listadto = new ArrayList<>();
		ProfesorDTO dto = null;

		for (Profesor profesor : repository.findAll()) {

			dto = new ProfesorDTO();
			dto.setCod(profesor.getIdProfesor());
			dto.setNom(profesor.getNombre());
			dto.setApe(profesor.getApellido());
			dto.setEspec(profesor.getEspecialidad());
			listadto.add(dto);
		}

		return listadto;
	}

	@Override
	public ProfesorDTO obtenerId(Integer id) {

		Profesor profesor = repository.findById(id).orElse(null);
		ProfesorDTO profesordto = new ProfesorDTO();

		profesordto.setCod(profesor.getIdProfesor());
		profesordto.setNom(profesor.getNombre());
		profesordto.setApe(profesor.getApellido());
		profesordto.setEspec(profesor.getEspecialidad());

		return profesordto;

	}

	@Override
	public void guardar(ProfesorDTO a) {

		Profesor profesor = new Profesor();

		profesor.setIdProfesor(a.getCod());
		profesor.setNombre(a.getNom());
		profesor.setApellido(a.getApe());
		profesor.setEspecialidad(a.getEspec());

		repository.save(profesor);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void actualizar(ProfesorDTO a) {

		Profesor profesor = new Profesor();

		profesor.setIdProfesor(a.getCod());
		profesor.setNombre(a.getNom());
		profesor.setApellido(a.getApe());
		profesor.setEspecialidad(a.getEspec());

		repository.saveAndFlush(profesor);

	}

}
