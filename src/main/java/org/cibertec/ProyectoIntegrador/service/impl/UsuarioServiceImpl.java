package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Usuario;
import org.cibertec.ProyectoIntegrador.repository.UsuarioRepositorio;
import org.cibertec.ProyectoIntegrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario guardar(Usuario usu) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.save(usu);
	}

	@Override
	public Usuario actualizar(Usuario usu) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.save(usu);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		usuarioRepositorio.deleteById(id);
	}

	@Override
	public Usuario buscarUsuario(int id) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findById(id).get();
	}

}
