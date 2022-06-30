package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Soporte;
import org.cibertec.ProyectoIntegrador.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")

public class SoporteRest {
	@Autowired
	SoporteService SoporteService;
	
	@GetMapping("/listar/soporte")
	public List<Soporte> api(Model map){
		return  SoporteService.listarSoporte();
	}
	@GetMapping("{id}")
	public Soporte obtenerSoporte(@PathVariable int id) {
		return SoporteService.buscaSoporte(id);
	}
	@PostMapping("/registrar/soporte")
	public Soporte insertar(@RequestBody Soporte soporte) {
		return SoporteService.Insertar(soporte);
	}
	@PostMapping("/actualizar/soporte")
	public Soporte actualizar(@RequestBody Soporte soporte) {
		return SoporteService.Actualizar(soporte);
	}
	
	
	
	
	
	
	
}
