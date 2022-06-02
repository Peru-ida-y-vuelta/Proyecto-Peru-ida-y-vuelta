package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;


import org.cibertec.ProyectoIntegrador.entidades.Unidades;
import org.cibertec.ProyectoIntegrador.repository.UnidadRepository;
import org.cibertec.ProyectoIntegrador.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnidadServiceImpl implements UnidadService {

	@Autowired
	private UnidadRepository uniRepo;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Unidades> listarUnidad() {
		return uniRepo.findAll();
	}

	@Override
	public Unidades grabarUni(Unidades uni) {
		return uniRepo.save(uni);
	}

	@Override
	public Unidades actualizarUni(Unidades uni) {
		return uniRepo.save(uni);
	}

	@Override
	public void eliminarUni(int id) {
		uniRepo.deleteById(id);
		
	}

	@Override
	public Unidades buscarUni(int id) {
		
		return uniRepo.findById(id).get();
	}
}
