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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/chofer")
public class ChoferControlador {

	@Autowired
	 ChoferService choferService;
	
    @GetMapping("/")
    public ModelAndView listaChofer() {
  	return new ModelAndView("chofer/listarchofer").addObject("choferes", choferService.listarChofer());
	}
    
    @GetMapping("/nuevo")
    public String nuevoChofer(Model model){
    	model.addAttribute("chofer", new Chofer());
    	return"chofer/guardarchofer";
    }
    
    @PostMapping("/crear")
    public String registrarChofer(@Valid Chofer chofer, Errors error,
    		RedirectAttributes attribute) {//BindingResult bindingResult
    	if(error.hasErrors()) {
    		return"chofer/guardarchofer";
    	}
    	choferService.guardar(chofer);
    	attribute.addFlashAttribute("success", "Chofer Agregado");
    	return"redirect:/chofer/";
    }
    
    @GetMapping("/editar/{idChofer}")
    public String editarChofer(@PathVariable("idChofer")Integer idChofer,Model model
    		,RedirectAttributes attribute) {
        model.addAttribute("chofer",choferService.buscarChofer(idChofer));	
        
    	return "chofer/editarchofer";
    }
    
    @PostMapping("/actualizar")
    public String actualizarChofer(@Valid @ModelAttribute Chofer chofer, Errors error,
    		RedirectAttributes attribute) {
    	
    	if(error.hasErrors()) {
    	    	return "chofer/editarchofer";
    	}
    	choferService.actualizar(chofer);
    	attribute.addFlashAttribute("warning", "Chofer Actualizado");
    	return"redirect:/chofer/";
    }
    
    
    
    
    
    
    
    
    @GetMapping("/eliminar/{idChofer}")
    public String choferEliminar(@ModelAttribute("idChofer") int idChofer) {
    	 choferService.eliminar(idChofer);
    	return "redirect:/chofer/";
    }
    
    
    
}
