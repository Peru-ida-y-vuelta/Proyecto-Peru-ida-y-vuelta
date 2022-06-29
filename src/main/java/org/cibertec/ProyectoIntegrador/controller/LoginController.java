package org.cibertec.ProyectoIntegrador.controller;

import javax.validation.Valid;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.entidades.TipoUsuario;
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
	
	@PostMapping("login/validar")
	public String validarLogin(@ModelAttribute Usuario usuario,Model model) 
	{
		System.out.println("Enviado : " + usuario);
		
		Usuario u = logService.ValidarLogin(usuario.getEmail(), usuario.getClave());
		
		System.out.println(u);
		
		if(u == null) {
			
			model.addAttribute("mensaje","Usuario o clave incorrecta");
			return "login";
		}
		return "dashboard";
	}
	
	
	
	@GetMapping("usuarios/cargar")
    public String nuevoUsuario(Model model){
    	model.addAttribute("usuario", new Usuario());
    	return"usuarios/guardarusuario";
    }
	
	@PostMapping("usuarios/grabar")
    public String registrarUsuario(@Valid Usuario usuario, Errors error,Model model) {
    	if(error.hasErrors()) {
    		return"usuarios/guardarusuario";
    	}
    	
    	if (logService.ValidarCorreo(usuario.getEmail()) != null) {
			model.addAttribute("validar", "Esta correo ya existe");
			System.out.println("Correo existe");
			return "usuarios/guardarusuario";
		}
    	System.out.println(usuario);
    	
    	TipoUsuario t = new TipoUsuario();
    	t.setId(1);
    	usuario.setTipo(t);
    	System.out.println(usuario);
    	logService.grabar(usuario);
    	return"redirect:/";
    }
}
