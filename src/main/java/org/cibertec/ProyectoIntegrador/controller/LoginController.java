package org.cibertec.ProyectoIntegrador.controller;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.entidades.Usuario;
import org.cibertec.ProyectoIntegrador.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController{

	@Autowired
	LoginService logService;
	
	@GetMapping("/")
	public String Login(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "Login";
	}
	@PostMapping("/login/validar")
	public String validarLogin(@ModelAttribute Usuario usuario,Model model) 
	{
		System.out.println("Enviado : " + usuario);
		
		Usuario u = logService.ValidarLogin(usuario.getCorreo(), usuario.getClave());
		
		System.out.println(u);
		
		if(u == null) {
			
			model.addAttribute("mensaje","Usuario o clave incorrecta");
			return "login";
		}
		return "dashboard";
	}
	
	@GetMapping("/usuarios/cargar")
	public String abrirRegistro(Model model) 
	{
		model.addAttribute("usuario",new Usuario());
		
		return "usuarios/registrarUsuario";
	}
	
	@PostMapping("/usuarios/grabar")
	public String grabarRegistro(@Valid Usuario usuario, Errors error) 
	{
		if(error.hasErrors()) {
    		return"usuarios/registrarUsuario";
    	}
		usuario.setTipo(1);
		logService.grabarUsu(usuario);
		return "login";
	}
}
