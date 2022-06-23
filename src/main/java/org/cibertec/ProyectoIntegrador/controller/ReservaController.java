package org.cibertec.ProyectoIntegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Reserva;
import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;
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

@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	ReservaService reservaService;
	@Autowired
	TipoViajeService tipoviajeService;
	
	
	
   //////////////////////////
	@GetMapping("/")  //listado de reservas///
	public String listarReservas(Model model) {
		model.addAttribute("reservas", reservaService.listarReserva());
		return "/reserva/listarreserva";
	}

	@GetMapping("/crear")
	public String crearReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
		return "/reserva/guardarreserva";
	}
	
	/////////////////////
	
	@PostMapping("/grabar")
	public String grabarReserva(@Valid @ModelAttribute Reserva reserva, BindingResult result, Model model,
			RedirectAttributes attribute) {
		//model.addAttribute("reservas", reservaService.listarReserva());
		
		if (result.hasErrors()) {
			model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
			return "/reserva/guardarreserva";
		}
		reservaService.grabarReser(reserva);
		attribute.addFlashAttribute("success", "Reserva Agregada");
		return "redirect:/reserva/"; ///evaluar cambio de ruta
		
	}

	
	///terminado editar//
	@GetMapping("/editar/{id}")
	public String editaReserva(@PathVariable("id") Integer idRsv, Model model,RedirectAttributes attribute) {

		if (idRsv > 0) {
				Reserva reserva = reservaService.buscarReser(idRsv);
			if (reserva == null ) {
				System.out.println("ID de Reserva  no encontrada");
				attribute.addFlashAttribute("error", "ID de Reserva no encontrada");
				return "redirect:/reserva/";
			}
		} else {
			System.out.println("Error con el ID de Reserva");
			attribute.addFlashAttribute("error", "Error con la ID de Reserva");
			return "redirect:/reserva/";
		}

		List<TipoViaje> tipoviajes = tipoviajeService.listarTipoViaje();
		Reserva reserva = reservaService.buscarReser(idRsv);
		model.addAttribute("reserva", reserva);
		model.addAttribute("tipoviajes", tipoviajes);
		return "/reserva/editarreserva";
	}
	
	
	
	
	//////actualizar reservaterminado//

	@PostMapping("/actualizar")
	public String actualizarReserva(@Valid @ModelAttribute Reserva reserva, BindingResult result, Model model,
			RedirectAttributes attribute) {
		List<TipoViaje> tipoviajes = tipoviajeService.listarTipoViaje();

		if (result.hasErrors()) {
			model.addAttribute("tipoviajes", tipoviajes);
			return "/reserva/guardarreserva";
		}
		reservaService.actualizarReser(reserva);
		attribute.addFlashAttribute("warning", "Reserva Actualizada");
		return "redirect:/reserva/";
	}
	
	//eliminar terminado

	@GetMapping("/eliminar/{id}")
	public String reservaEliminar(@PathVariable("id") Integer idRsv) {
		reservaService.eliminarReser(idRsv);
		return "redirect:/reserva/";
	}
}
