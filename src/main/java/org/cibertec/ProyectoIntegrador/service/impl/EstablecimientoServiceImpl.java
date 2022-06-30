package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Establecimiento;
import org.cibertec.ProyectoIntegrador.repository.EstablecimientoRepository;
import org.cibertec.ProyectoIntegrador.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService{
	
	@Autowired
	EstablecimientoRepository establecimientoRepository;

	@Override
	public List<Establecimiento> listarEstablecimientos() {
		return  (List<Establecimiento>) establecimientoRepository.findAll();
	}

	@Override
	public Establecimiento registrar(Establecimiento establecimiento) {
		return establecimientoRepository.save(establecimiento);
		
	}

	@Override
	public Establecimiento actualizar(Establecimiento establecimiento) {
		
		return establecimientoRepository.save(establecimiento);
	}

	@Override
	public Establecimiento obtenerPorId(int id) {
		return establecimientoRepository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
	establecimientoRepository.deleteById(id);
		
	}

}
