package org.cibertec.ProyectoIntegrador.service;


import java.util.List;
import java.util.Optional;

import org.cibertec.ProyectoIntegrador.entidades.Orden;
import org.cibertec.ProyectoIntegrador.entidades.Usuario;




public interface IOrdenService {
	List<Orden> findAll();
	Optional<Orden> findById(Integer id);
	Orden save (Orden orden);
	String generarNumeroOrden();
	List<Orden> findByUsuario (Usuario usuario);
}
