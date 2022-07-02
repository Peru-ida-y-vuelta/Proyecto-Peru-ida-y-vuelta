package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Libro;

import org.cibertec.ProyectoIntegrador.repository.LibroRepository;
import org.cibertec.ProyectoIntegrador.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroImpl implements LibroService {
	
	
	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<Libro> listarLibros() {
		return  (List<Libro>) libroRepository.findAll();
		
	}

	@Override
	public Libro registrar(Libro libro) {
		 return libroRepository.save(libro);
		
	}

	@Override
	public Libro actualizar(Libro libro) {
		return libroRepository.save(libro);	
	}

	@Override
	public Libro obtenerPorId(int id) {
		return libroRepository.findById(id).get();
		
	}

	@Override
	public void eliminar(int id) {
		libroRepository.deleteById(id);
	}
	

}
