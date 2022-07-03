package org.cibertec.ProyectoIntegrador.repository;

import org.cibertec.ProyectoIntegrador.entidades.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {

}
