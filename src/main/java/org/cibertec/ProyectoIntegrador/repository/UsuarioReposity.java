package org.cibertec.ProyectoIntegrador.repository;

import org.cibertec.ProyectoIntegrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioReposity extends JpaRepository<Usuario, Integer>{

	Usuario findByCorreoAndClave(String user,String pass);
}
