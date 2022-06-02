package org.cibertec.ProyectoIntegrador.repository;

import org.cibertec.ProyectoIntegrador.model.Unidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<Unidades, Integer>{

}
