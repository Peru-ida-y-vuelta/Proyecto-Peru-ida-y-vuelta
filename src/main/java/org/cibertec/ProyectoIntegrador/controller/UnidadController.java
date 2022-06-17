package org.cibertec.ProyectoIntegrador.controller;



import java.util.List;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.entidades.Unidad;
import org.cibertec.ProyectoIntegrador.service.ChoferService;
import org.cibertec.ProyectoIntegrador.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/unidad")
public class UnidadController {

	@Autowired
	UnidadService uniService;
	@Autowired
	ChoferService choService;
	 
	@GetMapping("/")
	public String listarUnidades(Model model) {
		model.addAttribute("unidades", uniService.listarUnidad());
		return "/unidad/listarunidad";
	}
	
	@GetMapping("/crear")
	public String crearUnidad(Model model) {
		model.addAttribute("unidad", new Unidad());
		model.addAttribute("choferes", choService.listarChofer());
		return "/unidad/guardarunidad";
	}
	@PostMapping("/grabar")
	public String grabarUnidad(@Valid @ModelAttribute Unidad unidad,BindingResult result,Model model) {
		List<Chofer> choferes = choService.listarChofer();

		if (result.hasErrors()) {
			model.addAttribute("choferes", choService.listarChofer());
			return "/unidad/guardarunidad";
		}
		if (uniService.validaPlaca(unidad.getPlaca()) != null) {
			model.addAttribute("validar", "Esta placa ya existe");
			System.out.println("Placa existe");
			model.addAttribute("choferes", choferes);
			return "/unidad/guardarunidad";
		}
		uniService.grabarUni(unidad);
		return "redirect:/unidad/";
	}
	@GetMapping("/editar/{id}")
	public String editaUnidad(@PathVariable("id") Integer idUnidad,Model model) {
		
		List<Chofer> choferes = choService.listarChofer();
		Unidad unidad = uniService.buscarUni(idUnidad);
		model.addAttribute("unidad", unidad);
		model.addAttribute("choferes", choferes);
		
		return "/unidad/editarunidad";
	}
	
	@PostMapping("/actualizar")
	public String actualizarUnidad(@Valid @ModelAttribute Unidad unidad,BindingResult result,Model model) {
		List<Chofer> choferes = choService.listarChofer();

		if (result.hasErrors()) {
			model.addAttribute("choferes", choferes);
			return "/unidad/guardarunidad";
		}
		
		uniService.actualizarUni(unidad);
		return "redirect:/unidad/";
	}
	
	@GetMapping("/eliminar/{id}")
    public String choferEliminar(@PathVariable("id") Integer idUnidad) {
    	 uniService.eliminarUni(idUnidad);
    	return "redirect:/unidad/";
    }
}
