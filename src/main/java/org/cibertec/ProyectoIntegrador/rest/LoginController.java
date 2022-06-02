package org.cibertec.ProyectoIntegrador.rest;

import org.cibertec.ProyectoIntegrador.model.Usuario;
import org.cibertec.ProyectoIntegrador.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
@Autowired
	private UsuarioService usuService;

@GetMapping("/login/cargar")
public String abrirLogin(Model model) 
{
	
	model.addAttribute("usuario",new Usuario());
	return "login";
}

@PostMapping("/login/validar")
public String validarLogin(@ModelAttribute Usuario usuario,Model model) 
{
	System.out.println("Enviado : " + usuario);
	
	Usuario u = usuService.Validar(usuario.getCorreo(),usuario.getClave());
	
	System.out.println(u);
	
	if(u == null) {
		
		model.addAttribute("mensaje","Usuario o clave incorrecta");
		return "login";
		
	}
	model.addAttribute("usuario", u);
	return "Inicio";
}
@GetMapping("/usuarios/cargar")
public String abrirRegistro(Model model) 
{
	model.addAttribute("usuario",new Usuario());
	
	return "registrarUsuario";
}

@PostMapping("/usuarios/grabar")
public String grabarRegistro(@ModelAttribute Usuario usuario,Model model) 
{
	System.out.println("Enviado 1 : " + usuario);

	usuario.setTipo(1);
	
	System.out.println("Enviado 2 : " + usuario);
	
	try {
		usuService.Crear(usuario);
		model.addAttribute("success", "Usuario Registrado");
		
	}catch (Exception e) {
		model.addAttribute("error", "Error al ingresar los datos");
	}
		return "registrarUsuario";
		
	}
}
