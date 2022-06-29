package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;
import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;
import org.cibertec.ProyectoIntegrador.service.CategoriaReservaService;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClaseRest {

	@Autowired
	private CategoriaReservaService service;
	
	@GetMapping("listar/Categoria")
	public List<CategoriaReserva>listar(){
		return service.listarCategoriaReserva();
	}
	@PostMapping("grabar/Categoria")
	public void grabar(@RequestBody CategoriaReserva cate) {
		 service.grabar(cate);
	}
}
