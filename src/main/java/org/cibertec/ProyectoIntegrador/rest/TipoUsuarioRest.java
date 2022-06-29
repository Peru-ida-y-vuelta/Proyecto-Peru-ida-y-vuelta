package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.TipoUsuario;
import org.cibertec.ProyectoIntegrador.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TipoUsuarioRest {

	@Autowired
	private TipoUsuarioService service;
	
	@GetMapping("/listar/TipoUsu")
	public List<TipoUsuario>listar(){
		return service.listar();
	}
	@PostMapping("/grabar/tipoUsu")
	public void grabar(@RequestBody TipoUsuario tipoUsu) {
		 service.grabar(tipoUsu);
	}
}
