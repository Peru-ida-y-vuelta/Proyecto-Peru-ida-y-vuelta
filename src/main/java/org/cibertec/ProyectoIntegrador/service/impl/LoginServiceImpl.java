package org.cibertec.ProyectoIntegrador.service.impl;

import org.cibertec.ProyectoIntegrador.entidades.Usuario;
import org.cibertec.ProyectoIntegrador.repository.LoginRepository;
import org.cibertec.ProyectoIntegrador.service.LoginService;
import org.cibertec.ProyectoIntegrador.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired LoginRepository logRepo;
	
	@Override
	public Usuario grabarUsu(Usuario usu) {
		return logRepo.save(usu);
	}

	@Override
	public Usuario ValidarLogin(String user, String pass) {
		return logRepo.findByCorreoAndClave(user, pass);
	}
}
