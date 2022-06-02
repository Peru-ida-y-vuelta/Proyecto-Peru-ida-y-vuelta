package org.cibertec.ProyectoIntegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/")
	public String plantilla() {
		return "dashboard";
	}
}
