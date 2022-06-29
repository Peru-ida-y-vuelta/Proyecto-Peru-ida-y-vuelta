package org.cibertec.ProyectoIntegrador.repository;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoferRepositorio extends JpaRepository<Chofer, Integer> {

}
