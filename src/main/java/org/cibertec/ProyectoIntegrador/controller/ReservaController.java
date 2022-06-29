package org.cibertec.ProyectoIntegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;
import org.cibertec.ProyectoIntegrador.entidades.Reserva;
import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;
import org.cibertec.ProyectoIntegrador.service.CategoriaReservaService;
import org.cibertec.ProyectoIntegrador.service.ReservaService;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.validation.Errors;



@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	@Autowired
	TipoViajeService tipoviajeService;
	@Autowired
	CategoriaReservaService categoriareservaservice; 
	
   //terminado-//
	@GetMapping("/")  //listado de reservas///
	public String listarReservas(Model model) {
		model.addAttribute("reservas", reservaService.listarReserva());	
		return "reserva/listarreserva";
	}
	
	
	@GetMapping("/crear")
	public String crearReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
		model.addAttribute("categoriareservas", categoriareservaservice.listarCategoriaReserva());
		return "reserva/guardarreserva";
	}
	
	//////Grabar Terminado//////////////
	
	@PostMapping("/grabar")
	public String grabarReserva(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result, Model model,
			RedirectAttributes attribute) { 
	
		if (result.hasErrors()) {
			model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
			model.addAttribute("categoriareservas", categoriareservaservice.listarCategoriaReserva());
			return "reserva/guardarreserva";
		}
		reservaService.grabarReser(reserva);
		attribute.addFlashAttribute("success", "Reserva Agregada");
		return "redirect:/reserva/";		
	}

	///terminado editar//
	@GetMapping("/editar/{idRsv}")
	public String editaReserva(@PathVariable("idRsv") Integer idRsv, Model model,RedirectAttributes attribute) {
		List<TipoViaje> tipoviajes = tipoviajeService.listarTipoViaje();
		List<CategoriaReserva> categoriareservas = categoriareservaservice.listarCategoriaReserva();
		Reserva reserva = reservaService.buscarReser(idRsv);
		model.addAttribute("reserva", reserva);
		model.addAttribute("tipoviajes", tipoviajes);
		model.addAttribute("categoriareservas", categoriareservas);
		return "reserva/editarreserva";
	}
	
	//////actualizar reservaterminado//

	@PostMapping("/actualizar")
	public String actualizarReserva(@Valid @ModelAttribute Reserva reserva, BindingResult result, Model model,
			RedirectAttributes attribute) {
		List<TipoViaje> tipoviajes = tipoviajeService.listarTipoViaje();
		List<CategoriaReserva> categoriareservas = categoriareservaservice.listarCategoriaReserva();

		if (result.hasErrors()) {
			model.addAttribute("tipoviajes", tipoviajes);
			model.addAttribute("categoriareservas", categoriareservas);
			return "reserva/guardarreserva";
		}
		reservaService.actualizarReser(reserva);
		attribute.addFlashAttribute("warning", "Reserva Actualizada");
		return "redirect:/reserva/";
	}
	
	
	
	
	
	
	
	
	
	
	
	//eliminar terminado

	@GetMapping("/eliminar/{idRsv}")
	public String reservaEliminar(@PathVariable("idRsv") Integer idRsv) {
		reservaService.eliminarReser(idRsv);
		return "redirect:/reserva/";
	}
}
