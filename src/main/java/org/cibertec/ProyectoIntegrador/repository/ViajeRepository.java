package org.cibertec.ProyectoIntegrador.repository;

import org.cibertec.ProyectoIntegrador.entidades.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

}
