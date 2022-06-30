package org.cibertec.ProyectoIntegrador.rest;

import java.net.URI;
import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
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
//
@RestController
@RequestMapping("/api/tipoviajes")
public class TipoViajeRestController {
	
	@Autowired
    private TipoViajeService tipoviajeService;
	
	@GetMapping
	public List<TipoViaje> listarTipoViajes() {
		return tipoviajeService.listarTipoViaje();
	} 
	
	
	@GetMapping("{id}")
	public TipoViaje ListarTipoViaje(@PathVariable int id) {
		return tipoviajeService.obtenerPorId(id);
	} 
	
	
	@PostMapping
	public ResponseEntity<TipoViaje> registrar(@RequestBody TipoViaje tipoviaje) {
		TipoViaje tipoviajeGuardada = tipoviajeService.registrar(tipoviaje);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tipoviajeGuardada.getCodigotpv()).toUri();

		return ResponseEntity.created(location).build();
	} 
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<TipoViaje> actualizar(@PathVariable int id, @RequestBody TipoViaje tipoviaje) {
		tipoviaje.setCodigotpv(id);
		tipoviajeService.actualizar(tipoviaje);
		return ResponseEntity.ok().build();
	} 
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<TipoViaje> eliminar(@PathVariable int id) {
		tipoviajeService.eliminar(id);
		return ResponseEntity.noContent().build();
	}  
	
}
