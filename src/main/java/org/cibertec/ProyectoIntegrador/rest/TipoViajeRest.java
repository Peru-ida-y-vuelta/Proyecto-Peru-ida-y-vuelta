package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;


import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoViajeRest {

	@Autowired
	private TipoViajeService service;
	
	@GetMapping("listar/TipoViaje")
	public List<TipoViaje>listar(){
		return service.listarTipoViaje();
	}
	@PostMapping("grabar/tipoViaje")
	public void grabar(@RequestBody TipoViaje tipoVi) {
		 service.grabar(tipoVi);
	}
}
