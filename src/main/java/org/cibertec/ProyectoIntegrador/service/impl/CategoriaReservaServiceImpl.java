package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;
import org.cibertec.ProyectoIntegrador.repository.CategoriaReservaRepository;
import org.cibertec.ProyectoIntegrador.service.CategoriaReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaReservaServiceImpl implements CategoriaReservaService{
	
	@Autowired
	private CategoriaReservaRepository categoriareservaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<CategoriaReserva> listarCategoriaReservas() {
		
		return ( List<CategoriaReserva>) categoriareservaRepository.findAll();
	}

	@Override
	@Transactional
	public CategoriaReserva registrar(CategoriaReserva categoriareserva) {	
		return categoriareservaRepository.save(categoriareserva);
	}
	
	

	@Override
	@Transactional
	public CategoriaReserva actualizar(CategoriaReserva categoriareserva) {
		
		return categoriareservaRepository.save(categoriareserva);
	}

	@Override
	@Transactional
	public void eliminar(int id) {
		
		categoriareservaRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public CategoriaReserva obtenerPorId(int id) {	
		return categoriareservaRepository.findById(id).get();
	}
	
}
