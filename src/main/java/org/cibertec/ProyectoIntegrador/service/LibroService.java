package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Libro;


public interface LibroService {
	
   List<Libro> listarLibros(); 

	 Libro registrar(Libro libro);

	 Libro actualizar(Libro libro);

	 Libro obtenerPorId(int id);

	 void eliminar(int id);

}
