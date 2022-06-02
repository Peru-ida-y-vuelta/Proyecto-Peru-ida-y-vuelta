package org.cibertec.ProyectoIntegrador.controller;


import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.entidades.Usuario;
import org.cibertec.ProyectoIntegrador.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
    public ModelAndView listaUsuario() {
  	return new ModelAndView("usuario/listarusuario").addObject("usuario",usuarioService.listarUsuario());
	}
	
	
	@GetMapping("/nuevo")
    public String nuevoUsuario(Model model){
    	model.addAttribute("usuario", new Usuario());
    	return"usuario/guardarUsuario";
    }
	
	
	
	@GetMapping("/eliminar/{idUsu}")
    public String UsuarioEliminar(@ModelAttribute("idUsu") int idUsu) {
    	 usuarioService.eliminar(idUsu);
    	return "redirect:/usuario";
    }
	
	@PostMapping("/crear")
    public String registrarUsuario(@Valid Usuario usuario, Errors error) {//BindingResult bindingResult
    	if(error.hasErrors()) {
    		return"usuario/guardarUsuario";
    	}
    	usuarioService.guardar(usuario);
    	return"redirect:/usuario";
    }
	
	@GetMapping("/editar/{idUsu}")
    public String editarUsuario(Model model, @ModelAttribute("idUsu") int idUsu) {
        model.addAttribute("usuario",usuarioService.buscarUsuario(idUsu));	
    	return "usuario/editarusuario";
    }
	
	 @PostMapping("/actualizar")
	public String actualizarUsuario(@Valid Usuario usu, Errors error) {	    	
	    	if(error.hasErrors()) {
	    	    	return "usuario/editarusuario";
	    	}
	    	usuarioService.actualizar(usu);
	    	return"redirect:/usuario";
	 }
	
}
