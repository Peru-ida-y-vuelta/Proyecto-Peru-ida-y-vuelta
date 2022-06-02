package org.cibertec.ProyectoIntegrador.rest;

import org.cibertec.ProyectoIntegrador.model.Unidades;
import org.cibertec.ProyectoIntegrador.model.Usuario;
import org.cibertec.ProyectoIntegrador.services.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UnidadController {
@Autowired
private UnidadService uniRepo;

@GetMapping("/unidades/listar")
public String abriPag(Model model)
	{
		model.addAttribute("lstUnidad", uniRepo.ListarTodo());
		return "MntUnidades";
	}


@GetMapping("/unidades/crear")
public String crearUnidadCargar(@ModelAttribute Unidades u,Model model)
{
	model.addAttribute("unidad",new Unidades());
	
	return "registroUnidades";
}

@PostMapping("/unidades/grabar")
public String crearUnidadGrabar(@ModelAttribute Unidades unidad,Model model) 
{
	System.out.println("Enviado : " + unidad);

	
	
	try {
		uniRepo.Crear(unidad);
		model.addAttribute("success", "Unidad Registrado");
		
	}catch (Exception e) {
		model.addAttribute("error", "Error al ingresar los datos");
	}
	
	model.addAttribute("lstUnidad", uniRepo.ListarTodo());
	
		return "MntUnidades";
		
	}



@PostMapping("/unidades/editar")
public String editarUnidad(@ModelAttribute Unidades u,Model model)
{
	System.out.println("Leyendo : " + u);
	
	model.addAttribute("unidad",uniRepo.listarXId(u.getId()));
	
	
	return "ActualizarUnidad";
}

@PostMapping("/unidades/editar/grabar")
public String editarUnidadGrabar(@ModelAttribute Unidades unidad,Model model)
{
	System.out.println("Enviando : " + unidad);
	
		uniRepo.Crear(unidad); 
		
		model.addAttribute("lstUnidad", uniRepo.ListarTodo());
		
	return "MntUnidades";
}


@PostMapping("/unidades/eliminar")
public String eliminarPag(@ModelAttribute Unidades u,Model model)
{
	
	Unidades uni = uniRepo.listarXId(u.getId());
	
	uniRepo.Eliminar(uni);
	
	model.addAttribute("lstUnidad", uniRepo.ListarTodo());
	
	return "MntUnidades";
}
}
