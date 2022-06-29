package org.cibertec.ProyectoIntegrador.controller;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.service.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/chofer")
public class ChoferControlador {

	@Autowired
	ChoferService choferService;
	
    @GetMapping
    public ModelAndView listaChofer() {
  	return new ModelAndView("chofer/listarchofer").addObject("choferes", choferService.listarChofer());
	}
    
    @GetMapping("/nuevo")
    public String nuevoChofer(Model model){
    	model.addAttribute("chofer", new Chofer());
    	return"chofer/guardarChofer";
    }
    
    @GetMapping("/eliminar/{idChofer}")
    public String choferEliminar(@ModelAttribute("idChofer") int idChofer) {
    	 choferService.eliminar(idChofer);
    	return "redirect:/chofer";
    }
    
    @PostMapping("/crear")
    public String registrarChofer(@Valid Chofer chofer, Errors error) {//BindingResult bindingResult
    	if(error.hasErrors()) {
    		return"chofer/guardarChofer";
    	}
    	choferService.guardar(chofer);
    	return"redirect:/chofer";
    }
    
    @GetMapping("/editar/{idChofer}")
    public String editarChofer(Model model, @ModelAttribute("idChofer") int idChofer) {
        model.addAttribute("chofer",choferService.buscarChofer(idChofer));	
    	return "chofer/editarchofer";
    }
    
    @PostMapping("/actualizar")
    public String actualizarChofer(@Valid Chofer chofer, Errors error) {
    	
    	if(error.hasErrors()) {
    	    	return "chofer/editarchofer";
    	}
    	choferService.actualizar(chofer);
    	return"redirect:/chofer";
    }
    
    
    
}
