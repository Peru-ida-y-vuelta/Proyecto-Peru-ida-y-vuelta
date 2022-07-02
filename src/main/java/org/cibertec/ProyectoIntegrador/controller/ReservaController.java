package org.cibertec.ProyectoIntegrador.controller;

import javax.validation.Valid;


import org.cibertec.ProyectoIntegrador.entidades.Reserva;

import org.cibertec.ProyectoIntegrador.service.CategoriaReservaService;
import org.cibertec.ProyectoIntegrador.service.ReservaService;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
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
@RequestMapping("/reserva")
public class ReservaController {
	
	
	@Autowired
	private ReservaService reservaService;
	@Autowired
	TipoViajeService tipoviajeService;
	@Autowired
	CategoriaReservaService categoriareservaService; 
	
   //terminado listado //
	@GetMapping 
	public String listarReservas(Model model) {
		model.addAttribute("reserva", reservaService.listarReservas());	
		return "reserva/listarreserva";
	}

	
   /// nuevo o crear --terminado//
	@GetMapping("/nuevo") 
	public String reservaNueva(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
		model.addAttribute("categoriareservas", categoriareservaService.listarCategoriaReservas());
		return "reserva/guardarreserva";
	}
		
	
	//////Grabar o crear Terminado/
	@PostMapping("/crear") 
	public String CrearReserva(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result, Model model,
			RedirectAttributes attribute) { 
	
		if (result.hasErrors()) {
			model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
			model.addAttribute("categoriareservas", categoriareservaService.listarCategoriaReservas());
			return "reserva/guardarreserva";
		}
		reservaService.registrar(reserva);
		attribute.addFlashAttribute("success", "Reserva Agregada");
		return "redirect:/reserva";		
		
	}
	
	///terminado editar//
	@GetMapping("/editar/{idRsv}")
	public String reservaEditar(@ModelAttribute("idRsv") int idRsv, Model model) {
		model.addAttribute("reserva", reservaService.obtenerPorId(idRsv));
		model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
		model.addAttribute("categoriareservas", categoriareservaService.listarCategoriaReservas());
		return "reserva/editarreserva";
	} 
			
	
	//////actualizar reservaterminado//

	@PostMapping("/actualizar")
	public String reservaActualizar(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result, Model model,
			RedirectAttributes attribute) {		
		if (result.hasErrors()) {
			model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
			model.addAttribute("categoriareservas", categoriareservaService.listarCategoriaReservas());
			return "reserva/guardarreserva";
		}
		reservaService.registrar(reserva);
		attribute.addFlashAttribute("warning", "Reserva Actualizada");
		return "redirect:/reserva";
	}
	
	
	//eliminar terminado

	@GetMapping("/eliminar/{idRsv}")
	public String reservaEliminar(@ModelAttribute("idRsv") int idRsv) {
		reservaService.eliminar(idRsv);
		return "redirect:/reserva";
	}
}
