package org.cibertec.ProyectoIntegrador.controller;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Libro;
import org.cibertec.ProyectoIntegrador.service.EstablecimientoService;
import org.cibertec.ProyectoIntegrador.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/libro")
public class LibroController {
	
	
	@Autowired
	LibroService libroService;
	@Autowired
	EstablecimientoService establecimientoService;
	
	
   /////////////////////
	@GetMapping
	public String listarLibroReclamos(Model model) {
		model.addAttribute("libro", libroService.listarLibros());
		return "libro/listarlibro";
		
		
	}

	
   //////////////////
	@GetMapping("/nuevo") 
	public String libroreclamoNuevo(Model model) {
		model.addAttribute("libro", new Libro());
		model.addAttribute("establecimientos", establecimientoService.listarEstablecimientos());
		
		return "libro/guardarlibro";
	}
		
	
	//////Grabar o crear Terminado/
	@PostMapping("/crear") 
	public String CrearLibroReclamo(@Valid @ModelAttribute("libro") Libro libro, BindingResult result, Model model,
			RedirectAttributes attribute) { 
	
		if (result.hasErrors()) {
			model.addAttribute("establecimientos", establecimientoService.listarEstablecimientos());
			return "libro/guardarlibro";
		}
		libroService.registrar(libro);
		attribute.addFlashAttribute("success", "Solicitud de Reclamo Agregado");
		return "redirect:/libro";		
		
	}
	
	///terminado editar//
	@GetMapping("/editar/{idlibro}")
	public String libroreclamoEditar(@ModelAttribute("idlibro") int idlibro, Model model) {
		model.addAttribute("libro", libroService.obtenerPorId(idlibro));
		model.addAttribute("establecimientos", establecimientoService.listarEstablecimientos());
		return "libro/editarlibro";
	} 
			
	
	//////actualizar reservaterminado//

	@PostMapping("/actualizar")
	public String libroreclamoActualizar(@Valid @ModelAttribute("libro") Libro libro, BindingResult result, Model model,
			RedirectAttributes attribute) {		
		if (result.hasErrors()) {
			model.addAttribute("establecimientos", establecimientoService.listarEstablecimientos());
			
			return "libro/guardarlibro";
		}
		libroService.registrar(libro);
		attribute.addFlashAttribute("warning", "Respuesta de Reclamo Actualizado");
		return "redirect:/libro";
	}
	
	
	
	//eliminar terminado

	@GetMapping("/eliminar/{idlibro}")
	public String libroreclamoEliminar(@ModelAttribute("idlibro") int idlibro) {
		libroService.eliminar(idlibro);
		return "redirect:/libro";
	}
	
	
	
	
	   
}
