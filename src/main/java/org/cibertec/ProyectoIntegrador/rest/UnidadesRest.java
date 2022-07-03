package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Unidad;
import org.cibertec.ProyectoIntegrador.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/unidades")
public class UnidadesRest {

	@Autowired
	private UnidadService service;
	
	@GetMapping("/listar")
	public List<Unidad> listar() {
		return service.listarUnidad();
	}
	@GetMapping("/buscar/{id}")
	public Unidad buscar(@PathVariable("id")Integer id) {
		return service.buscarUni(id);
	}
	@PostMapping("/grabar")
	public void grabar(@RequestBody Unidad uni) {
		 service.grabarUni(uni);
	}
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Unidad uni) {
		 service.grabarUni(uni);
	}
	@DeleteMapping("/eliminar/{id}")
	public void elimnar(@PathVariable("id")Integer id) {
		 service.eliminarUni(id);
	}
}
