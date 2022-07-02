package org.cibertec.ProyectoIntegrador.rest;

import java.net.URI;
import java.util.List;

import org.cibertec.ProyectoIntegrador.service.ReservaService;
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

import org.cibertec.ProyectoIntegrador.entidades.Reserva;
//
@RestController
@RequestMapping("/api/reservas")
public class ReservaRestController {

	@Autowired
	private ReservaService reservaService;

	@GetMapping
	public List<Reserva> listarReservas() {
		return reservaService.listarReservas();
	} 

	

	@GetMapping("{id}")
	public Reserva ListarReserva(@PathVariable int id) {
		return reservaService.obtenerPorId(id);
	} 

	
	
	@PostMapping
	public ResponseEntity<Reserva> registrar(@RequestBody Reserva reserva) {
		Reserva reservaGuardada = reservaService.registrar(reserva);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(reservaGuardada.getIdRsv()).toUri();

		return ResponseEntity.created(location).build();
	} 
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<Reserva> actualizar(@PathVariable int id, @RequestBody Reserva reserva) {
		reserva.setIdRsv(id);
		reservaService.actualizar(reserva);
		return ResponseEntity.ok().build();
	} 
	
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Reserva> eliminar(@PathVariable int id) {
		reservaService.eliminar(id);
		return ResponseEntity.noContent().build();
	} 

}
