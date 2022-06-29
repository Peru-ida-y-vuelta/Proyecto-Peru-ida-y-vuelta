package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;
import org.cibertec.ProyectoIntegrador.repository.CategoriaReservaRepository;
import org.cibertec.ProyectoIntegrador.service.CategoriaReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaReservaServiceImpl implements CategoriaReservaService{
	
	@Autowired
	private CategoriaReservaRepository categoriareservarepo;

	@Override
	public List<CategoriaReserva> listarCategoriaReserva() {
		
		return categoriareservarepo.findAll();
	}

	@Override
	public CategoriaReserva grabar(CategoriaReserva categoriareserva) {
		
		return categoriareservarepo.save(categoriareserva);
	}

	@Override
	public CategoriaReserva actualizar(CategoriaReserva categoriareserva) {
		
		return categoriareservarepo.save(categoriareserva);
	}

	@Override
	public void eliminar(int id) {
		
		categoriareservarepo.deleteById(id);
		
	}

	@Override
	public CategoriaReserva buscarCategoriaReserva(int id) {
		
		return categoriareservarepo.findById(id).get();
	}
	
}
