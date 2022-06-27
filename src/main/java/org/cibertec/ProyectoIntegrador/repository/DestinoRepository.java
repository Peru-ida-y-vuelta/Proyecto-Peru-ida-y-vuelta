package org.cibertec.ProyectoIntegrador.repository;

import org.cibertec.ProyectoIntegrador.entidades.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer> {

}
