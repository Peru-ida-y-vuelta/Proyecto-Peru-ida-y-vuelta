package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.TipoUsuario;
import org.cibertec.ProyectoIntegrador.repository.TipoUsuarioRepository;
import org.cibertec.ProyectoIntegrador.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioImpl implements TipoUsuarioService{
	

	@Autowired
	private TipoUsuarioRepository repo;
	
	@Override
	public List<TipoUsuario> listar() {
		return repo.findAll();
	}

	@Override
	public void grabar(TipoUsuario obj) {
		repo.save(obj);
		
	}

}
