package org.cibertec.ProyectoIntegrador.controller;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.entidades.Destino;
import org.cibertec.ProyectoIntegrador.service.DestinoService;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	DestinoService desService;
	@Autowired
	TipoViajeService tipoviajeService;
	
	 @GetMapping
	    public ModelAndView listarDestinos() {
	  	return new ModelAndView("destino/listardestino").addObject("destinos", desService.listarDestino());
		}
	 
	 @GetMapping("/nuevo")
	    public String nuevoDestino(Model model){
	    	model.addAttribute("destino", new Destino());
	    	model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
	    	return"destino/guardarDestino";
	    }
	 
	 @GetMapping("/eliminar/{id}")
	    public String eliminarDestino(@ModelAttribute("id") int iddes) {
	    	 desService.eliminarDes(iddes);
	    	return "redirect:/destino";
	    }
	 
	 @PostMapping("/crear")
	    public String registrarDestino(@Valid Destino destino,Model model, Errors error) {
	    	if(error.hasErrors()) {
	    		System.out.println(error);
	    		model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
	    		return"destino/guardarDestino";
	    		
	    	}
	    	desService.grabarDes(destino);
	    	return"redirect:/destino";
	    }
	 
	 @GetMapping("/editar/{id}")
	    public String editarDestino(Model model, @ModelAttribute("id") int id) {
		 model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
	        model.addAttribute("destino", desService.buscarDes(id));	
	    	return "destino/editardestino";
	    }
	 
	 @PostMapping("/actualizar")
	    public String actualizarDestino(@Valid Destino des,Model model, Errors error) {
	    	
	    	if(error.hasErrors()) {
	    		model.addAttribute("tipoviajes", tipoviajeService.listarTipoViaje());
	    	    	return "destino/editardestino";
	    	}
	    	desService.actualizarDes(des);
	    	return"redirect:/destino";
	    }
}

