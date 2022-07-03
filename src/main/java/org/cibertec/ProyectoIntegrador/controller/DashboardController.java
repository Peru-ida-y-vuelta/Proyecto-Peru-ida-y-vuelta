package org.cibertec.ProyectoIntegrador.controller;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Orden;
import org.cibertec.ProyectoIntegrador.entidades.Viaje;
import org.cibertec.ProyectoIntegrador.service.IOrdenService;
import org.cibertec.ProyectoIntegrador.service.UsuarioService;
import org.cibertec.ProyectoIntegrador.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {
	
	@Autowired
	private ViajeService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private IOrdenService ordensService;


	@GetMapping("/Inicio")
	public String plantilla() {
		return "dashboard";
	}
	
	@GetMapping("")
	public String home(Model model) {

		List<Viaje> productos = productoService.findAll();
		model.addAttribute("productos", productos);


		return "dashboard/home";
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.listarUsuario());
		return "dashboard/usuarios";
	}
	
	@GetMapping("/ordenes")
	public String ordenes(Model model) {
		model.addAttribute("ordenes", ordensService.findAll());
		return "dashboard/ordenes";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id) {
		
		Orden orden= ordensService.findById(id).get();
		
		model.addAttribute("detalles", orden.getDetalle());
		
		return "dashboard/detalleorden";
	}
	
	
}
