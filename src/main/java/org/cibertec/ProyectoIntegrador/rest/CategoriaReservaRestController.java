package org.cibertec.ProyectoIntegrador.rest;



import java.net.URI;
import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;
import org.cibertec.ProyectoIntegrador.service.CategoriaReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/categoriareservas")
public class CategoriaReservaRestController {
	
	//
	@Autowired
	private CategoriaReservaService categoriareservaService;
	
	@GetMapping
	public List<CategoriaReserva> listarCategoriasReservas() {
		return categoriareservaService.listarCategoriaReservas();
	} 	
	
	@GetMapping("{id}")
	public CategoriaReserva ListarCategoriasReserva(@PathVariable int id) {
		return categoriareservaService.obtenerPorId(id);
	} 
	
	
	@PostMapping
	public ResponseEntity<CategoriaReserva> registrar(@RequestBody CategoriaReserva categoriareserva) {
		CategoriaReserva categoriareservaGuardada = categoriareservaService.registrar(categoriareserva);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoriareservaGuardada.getCodigo_ctersv()).toUri();

		return ResponseEntity.created(location).build();
	} 
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<CategoriaReserva> actualizar(@PathVariable int id, @RequestBody CategoriaReserva categoriareserva) {
		categoriareserva.setCodigo_ctersv(id);
		categoriareservaService.actualizar(categoriareserva);
		return ResponseEntity.ok().build();
	} 
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<CategoriaReserva> eliminar(@PathVariable int id) {
		categoriareservaService.eliminar(id);
		return ResponseEntity.noContent().build();
	}   
	

}
