package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;
import org.cibertec.ProyectoIntegrador.repository.ChoferRepositorio;
import org.cibertec.ProyectoIntegrador.service.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChoferServiceImpl implements ChoferService {

	
	@Autowired
	ChoferRepositorio choferRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Chofer> listarChofer() {
		return choferRepositorio.findAll();
	}

	@Override
	@Transactional
	public Chofer guardar(Chofer chofer) {
		return choferRepositorio.save(chofer);
	}

	@Override
	@Transactional
	public Chofer actualizar(Chofer chofer) {
		return choferRepositorio.save(chofer);
	}

	@Override
	@Transactional
	public void eliminar(int id) {
		choferRepositorio.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Chofer buscarChofer(int id) {
		
		return choferRepositorio.findById(id).orElse(null);
	}

	
}
