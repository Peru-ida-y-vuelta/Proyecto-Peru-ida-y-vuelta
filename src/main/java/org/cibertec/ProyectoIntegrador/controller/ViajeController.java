package org.cibertec.ProyectoIntegrador.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.cibertec.ProyectoIntegrador.entidades.Usuario;
import org.cibertec.ProyectoIntegrador.entidades.Viaje;
import org.cibertec.ProyectoIntegrador.service.UploadFileService;
import org.cibertec.ProyectoIntegrador.service.UsuarioService;
import org.cibertec.ProyectoIntegrador.service.ViajeService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

;


@Controller
@RequestMapping("/productos")
public class ViajeController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ViajeController.class);
	
	@Autowired
	private ViajeService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Viaje producto, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		LOGGER.info("Este es el objeto producto {}",producto);
		
		
		Usuario u= usuarioService.buscarUsuario(Integer.parseInt(session.getAttribute("idusuario").toString() )).get();
		producto.setUsuario(u);	
		
		//imagen
		if (producto.getId()==null) { // cuando se crea un producto
			String nombreImagen= upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}else {
			
		}
		
		productoService.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Viaje producto= new Viaje();
		Optional<Viaje> optionalProducto=productoService.get(id);
		producto= optionalProducto.get();
		
		LOGGER.info("Producto buscado: {}",producto);
		model.addAttribute("producto", producto);
		
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Viaje producto, @RequestParam("img") MultipartFile file ) throws IOException {
		Viaje p= new Viaje();
		p=productoService.get(producto.getId()).get();
		
		if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
			
			producto.setImagen(p.getImagen());
		}else {// cuando se edita tbn la imagen			
			//eliminar cuando no sea la imagen por defecto
			if (!p.getImagen().equals("default.jpg")) {
				upload.deleteImage(p.getImagen());
			}
			String nombreImagen= upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		producto.setUsuario(p.getUsuario());
		productoService.update(producto);		
		return "redirect:/productos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Viaje p = new Viaje();
		p=productoService.get(id).get();
		
		//eliminar cuando no sea la imagen por defecto
		if (!p.getImagen().equals("default.jpg")) {
			upload.deleteImage(p.getImagen());
		}
		
		productoService.delete(id);
		return "redirect:/productos";
	}
	
	
}
