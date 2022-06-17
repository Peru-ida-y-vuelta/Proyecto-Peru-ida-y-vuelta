package org.cibertec.ProyectoIntegrador.repository;



import org.cibertec.ProyectoIntegrador.entidades.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Integer>{

	Unidad findByPlaca(String placa);
	}
