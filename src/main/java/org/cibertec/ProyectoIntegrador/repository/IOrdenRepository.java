package org.cibertec.ProyectoIntegrador.repository;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Orden;
import org.cibertec.ProyectoIntegrador.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {
	List<Orden> findByUsuario (Usuario usuario);
}
