package org.cibertec.ProyectoIntegrador.repository;


import org.cibertec.ProyectoIntegrador.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Usuario, Integer>{

	
	Usuario findByCorreoAndClave(String user,String pass);
}
