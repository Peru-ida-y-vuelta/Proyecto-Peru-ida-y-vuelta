package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Unidad;
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
	public List<Unidad> listarUnidad() {
		return uniRepo.findAll();
	}

	@Override
	public Unidad grabarUni(Unidad obj) {
		return uniRepo.save(obj);
	}

	@Override
	public Unidad actualizarUni(Unidad obj) {
		return uniRepo.save(obj);
	}

	@Override
	public void eliminarUni(int id) {
		uniRepo.deleteById(id);
	}

	@Override
	public Unidad buscarUni(int id) {
		return uniRepo.findById(id).orElse(null);
	}

	@Override
	public Unidad validaPlaca(String placa) {
		return uniRepo.findByPlaca(placa);
	}
	
	
}
