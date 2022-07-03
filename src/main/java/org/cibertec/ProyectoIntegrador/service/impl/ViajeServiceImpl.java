package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;
import java.util.Optional;

import org.cibertec.ProyectoIntegrador.entidades.Viaje;
import org.cibertec.ProyectoIntegrador.repository.ViajeRepository;
import org.cibertec.ProyectoIntegrador.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ViajeServiceImpl implements ViajeService{
	
	@Autowired
	private ViajeRepository viajeRepository;

	@Override
	public Viaje save(Viaje producto) {
		return viajeRepository.save(producto);
	}

	@Override
	public Optional<Viaje> get(Integer id) {
		return viajeRepository.findById(id);
	}

	@Override
	public void update(Viaje producto) {
		viajeRepository.save(producto);		
	}

	@Override
	public void delete(Integer id) {
		viajeRepository.deleteById(id);		
	}

	@Override
	public List<Viaje> findAll() {
		return viajeRepository.findAll();
	}

}
