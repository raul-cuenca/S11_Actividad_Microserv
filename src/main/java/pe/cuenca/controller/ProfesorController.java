package pe.cuenca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.cuenca.dto.ProfesorDTO;
import pe.cuenca.service.ProfesorService;

@Controller
@RequestMapping("/api/profesor/v1")
public class ProfesorController {

	@Autowired
	private ProfesorService servicio;

	@GetMapping("/listar")
	public @ResponseBody List<ProfesorDTO> listar() {
		return servicio.listar();
	}

	@GetMapping("/listar/{id}")
	public @ResponseBody ProfesorDTO obtenerId(@PathVariable Integer id) {
		return servicio.obtenerId(id);
	}

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody ProfesorDTO dto) {
		servicio.guardar(dto);
	}

	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody ProfesorDTO dto) {
		servicio.actualizar(dto);
	}

	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		servicio.eliminar(id);
	}

}
