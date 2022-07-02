package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;
import org.cibertec.ProyectoIntegrador.entidades.Establecimiento;
import org.cibertec.ProyectoIntegrador.service.CategoriaReservaService;
import org.cibertec.ProyectoIntegrador.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EstablecimientoRest {

	@Autowired
	private EstablecimientoService service;
	
	@GetMapping("listar/establecimiento")
	public List<Establecimiento>listar(){
		return service.listarEstablecimientos();
	}
	@PostMapping("grabar/establecimiento")
	public void grabar(@RequestBody Establecimiento est) {
		 service.registrar(est);
	}
}
