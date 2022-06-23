package org.cibertec.ProyectoIntegrador.controller;

import org.cibertec.ProyectoIntegrador.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//uribe
@Controller
@RequestMapping("/soporte")
public class SoporteController {
	
	@Autowired
	SoporteService SoporteService;
	
	@GetMapping
	public ModelAndView listarSoporte() {
		return new ModelAndView("Soporte/listarsoporte").addObject("soportes", SoporteService.listarSoporte());
	}
	
	
	
}
