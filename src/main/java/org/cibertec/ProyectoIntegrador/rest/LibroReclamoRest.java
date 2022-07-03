package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Libro;
import org.cibertec.ProyectoIntegrador.entidades.Unidad;
import org.cibertec.ProyectoIntegrador.service.LibroService;
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
@RequestMapping("api/libro")
public class LibroReclamoRest {
	@Autowired
	private LibroService service;
	
	@GetMapping("/listar")
	public List<Libro> listar() {
		return service.listarLibros();
	}
	@GetMapping("/buscar/{id}")
	public Libro buscar(@PathVariable("id")Integer id) {
		return service.obtenerPorId(id);
	}
	@PostMapping("/grabar")
	public void grabar(@RequestBody Libro lib) {
		 service.registrar(lib);
	}
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Libro lib) {
		 service.actualizar(lib);
	}
	@DeleteMapping("/eliminar/{id}")
	public void elimnar(@PathVariable("id")Integer id) {
		 service.eliminar(id);
	}
}
