package org.cibertec.ProyectoIntegrador.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.cibertec.ProyectoIntegrador.entidades.Destino;
import org.cibertec.ProyectoIntegrador.repository.DestinoRepository;
import org.cibertec.ProyectoIntegrador.service.DestinoService;
import org.springframework.transaction.annotation.Transactional;



@Service
public class DestinoServicelmpl implements DestinoService {

	@Autowired
	private DestinoRepository desRepo;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Destino> listarDestino() {
		return desRepo.findAll();
	}

	@Override
	public Destino grabarDes(Destino des) {
		return desRepo.save(des);
	}

	@Override
	public Destino actualizarDes(Destino des) {
		return desRepo.save(des);
	}

	@Override
	public void eliminarDes(int id) {
		desRepo.deleteById(id);
		
	}

	@Override
	public Destino buscarDes(int id) {
		
		return desRepo.findById(id).get();
	}
}
