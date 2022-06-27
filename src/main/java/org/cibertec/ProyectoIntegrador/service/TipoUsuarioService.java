package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.TipoUsuario;

public interface TipoUsuarioService {
	
	public List<TipoUsuario>listar();
	public void grabar(TipoUsuario obj);
	
}
