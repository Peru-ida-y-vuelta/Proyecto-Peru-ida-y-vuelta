package org.cibertec.ProyectoIntegrador.controller;



import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.entidades.Unidades;
import org.cibertec.ProyectoIntegrador.service.UnidadService;
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
@RequestMapping("/unidad")
public class UnidadController {

	@Autowired
	UnidadService uniService;
	
	 @GetMapping
	    public ModelAndView listarUnidades() {
	  	return new ModelAndView("unidad/listarunidad").addObject("unidades", uniService.listarUnidad());
		}
	 
	 @GetMapping("/nuevo")
	    public String nuevaUnidad(Model model){
	    	model.addAttribute("unidad", new Unidades());
	    	return"unidad/guardarUnidad";
	    }
	 
	 @GetMapping("/eliminar/{id}")
	    public String eliminarUnidad(@ModelAttribute("id") int iduni) {
	    	 uniService.eliminarUni(iduni);
	    	return "redirect:/unidad";
	    }
	 
	 @PostMapping("/crear")
	    public String registrarUnidad(@Valid Unidades unidad, Errors error) {
	    	if(error.hasErrors()) {
	    		return"unidad/guardarunidad";
	    	}
	    	uniService.grabarUni(unidad);
	    	return"redirect:/unidad";
	    }
	 
	 @GetMapping("/editar/{id}")
	    public String editarUnidad(Model model, @ModelAttribute("id") int id) {
	        model.addAttribute("unidad", uniService.buscarUni(id));	
	    	return "unidad/editarunidad";
	    }
	 
	 @PostMapping("/actualizar")
	    public String actualizarUnidad(@Valid Unidades uni, Errors error) {
	    	
	    	if(error.hasErrors()) {
	    	    	return "unidad/editarunidad";
	    	}
	    	uniService.actualizarUni(uni);
	    	return"redirect:/unidad";
	    }
}
