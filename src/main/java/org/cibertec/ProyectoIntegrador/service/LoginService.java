package org.cibertec.ProyectoIntegrador.service;


import org.cibertec.ProyectoIntegrador.entidades.Usuario;

public interface LoginService {


	public Usuario grabarUsu(Usuario usu);
	
	public Usuario ValidarLogin(String user,String pass);
}
