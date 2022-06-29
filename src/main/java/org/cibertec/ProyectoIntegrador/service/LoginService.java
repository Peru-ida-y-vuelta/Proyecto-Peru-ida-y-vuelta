package org.cibertec.ProyectoIntegrador.service;


import org.cibertec.ProyectoIntegrador.entidades.Usuario;

public interface LoginService {


	public Usuario grabar(Usuario usu) ;
	
	public Usuario ValidarLogin(String user,String pass);
	
	public Usuario ValidarCorreo(String user);
}
