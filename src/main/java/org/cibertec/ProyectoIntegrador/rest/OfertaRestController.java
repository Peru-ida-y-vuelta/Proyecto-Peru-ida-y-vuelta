package org.cibertec.ProyectoIntegrador.rest;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRestController {
	@Autowired
	org.cibertec.ProyectoIntegrador.service.OfertaService OfertaService;
	
	@GetMapping("/listar")
	public List<Oferta> api(Model map){
		return  OfertaService.listarOferta();
	}
	@GetMapping("{id}")
	public Oferta obtenerOferta(@PathVariable int id) {
		return OfertaService.buscarOferta(id);
	}
	@PostMapping("/registrar")
	public Oferta agregar(@RequestBody Oferta oferta) {
		return OfertaService.agregar(oferta);
	}
	@PostMapping("/editar")
	public Oferta actualizar(@RequestBody Oferta oferta) {
		return OfertaService.editar(oferta);
	}
}
