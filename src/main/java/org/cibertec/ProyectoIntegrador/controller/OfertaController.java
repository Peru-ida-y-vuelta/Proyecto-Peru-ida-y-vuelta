package org.cibertec.ProyectoIntegrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Oferta;
import org.cibertec.ProyectoIntegrador.service.OfertaService;
import org.cibertec.ProyectoIntegrador.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	@Autowired
	OfertaService OfertaService;
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ModelAndView listarOferta() {
		return new ModelAndView("oferta/listaroferta").addObject("ofertas", OfertaService.listarOferta());
	}
	
    @GetMapping("/nuevo")
    public String nuevoSoporte(Model model){
    	model.addAttribute("oferta", new Oferta());
    	model.addAttribute("listarusuario",usuarioService.listarUsuario());
    	return"oferta/agregaroferta";
    }
    
    @PostMapping("/agregar")
    public String registrarSoporte(@Valid Oferta oferta, Errors error) {
    	if(error.hasErrors()) {
    		return"oferta/agregaroferta";
    	}
    	OfertaService.agregar(oferta);
    	return"redirect:/oferta";
    }
    
    @GetMapping("/eliminar/{idOferta}")
    public String ofertaEliminar(@ModelAttribute("idOferta") int idOferta) {
    	OfertaService.eliminar(idOferta);
    	return "redirect:/oferta";
    }
    
    
    @GetMapping("/editar/{idOferta}")
    public String editarOferta(Model model, @ModelAttribute("idOferta") int idOferta) {
        model.addAttribute("oferta",OfertaService.buscarOferta(idOferta));	
        model.addAttribute("listarusuario",usuarioService.listarUsuario());
    	return "oferta/editaroferta";
    }
    
    @PostMapping("/actualizar")
    public String actualizarSoporte(@Valid Oferta oferta, Errors error) {
    	
    	if(error.hasErrors()) {
    	    	return "oferta/editaroferta";
    	}
    	OfertaService.editar(oferta);
    	return"redirect:/oferta";
    }
    
	
}
