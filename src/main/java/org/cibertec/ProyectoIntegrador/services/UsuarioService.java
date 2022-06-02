package org.cibertec.ProyectoIntegrador.services;

import org.cibertec.ProyectoIntegrador.model.Usuario;
import org.cibertec.ProyectoIntegrador.repository.UsuarioReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioReposity usuRepo;
	
	public Usuario Validar(String user,String pass) {
		return usuRepo.findByCorreoAndClave(user, pass);
	}
	public Usuario Crear(Usuario obj) {
		return usuRepo.save(obj);
	}
}
