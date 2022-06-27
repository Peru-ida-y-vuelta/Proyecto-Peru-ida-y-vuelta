package org.cibertec.ProyectoIntegrador.repository;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaReservaRepository extends JpaRepository<CategoriaReserva, Integer> {

}
