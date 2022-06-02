package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Usuario;

public interface UsuarioService {
	public List<Usuario> listarUsuario();
	public Usuario guardar(Usuario usu);
	public Usuario actualizar(Usuario usu);
	public void eliminar(int id);
	public Usuario buscarUsuario(int id);

}
