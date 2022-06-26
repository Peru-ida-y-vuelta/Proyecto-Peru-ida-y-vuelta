package org.cibertec.ProyectoIntegrador.controller;
import javax.validation.Valid;


import org.cibertec.ProyectoIntegrador.entidades.Soporte;

import org.cibertec.ProyectoIntegrador.service.UsuarioService;
import org.cibertec.ProyectoIntegrador.service.impl.SoporteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//uribe
@Controller
@RequestMapping("/soporte")
public class SoporteController {
	@Autowired
	SoporteServiceImpl SoporteService;
	@Autowired
	UsuarioService usuarioService;
	@GetMapping
	public ModelAndView listarSoporte() {
		return new ModelAndView("soporte/listarsoporte").addObject("soportes", SoporteService.listarSoporte());
	}
	
    @GetMapping("/nuevo")
    public String nuevoSoporte(Model model){
    	model.addAttribute("soporte", new Soporte());
    	model.addAttribute("listarusuario",usuarioService.listarUsuario());
    	return"soporte/registrarsoporte";
    }
    
    @PostMapping("/insertar")
    public String registrarSoporte(@Valid Soporte soporte, Errors error) {
    	if(error.hasErrors()) {
    		return"soporte/registrarsoporte";
    	}
    	SoporteService.Insertar(soporte);
    	return"redirect:/soporte";
    }
    
    
    @GetMapping("/eliminar/{idSoporte}")
    public String clienteEliminar(@ModelAttribute("idSoporte") int idSoporte) {
    	SoporteService.eliminar(idSoporte);
    	return "redirect:/soporte";
    }
    
    @GetMapping("/editar/{idSoporte}")
    public String editarSoporte(Model model, @ModelAttribute("idSoporte") int idSoporte) {
        model.addAttribute("soporte",SoporteService.buscaSoporte(idSoporte));	
        model.addAttribute("listarusuario",usuarioService.listarUsuario());
    	return "soporte/editarsoporte";
    }
    
    @PostMapping("/actualizar")
    public String actualizarSoporte(@Valid Soporte soporte, Errors error) {
    	
    	if(error.hasErrors()) {
    	    	return "soporte/editarsoporte";
    	}
    	SoporteService.Actualizar(soporte);
    	return"redirect:/soporte";
    }

    
    
}
