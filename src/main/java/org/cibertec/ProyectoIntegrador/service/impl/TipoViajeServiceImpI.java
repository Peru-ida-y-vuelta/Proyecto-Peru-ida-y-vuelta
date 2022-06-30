package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;
import org.cibertec.ProyectoIntegrador.repository.TipoViajeRepository;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//
@Service
public class TipoViajeServiceImpI implements TipoViajeService{
	
	@Autowired
	private TipoViajeRepository tipoviajeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<TipoViaje> listarTipoViaje() {		
		return   (List<TipoViaje>) tipoviajeRepository.findAll();
		
	}

	@Override
	@Transactional
	public TipoViaje registrar(TipoViaje tipoviaje) {	
		return tipoviajeRepository.save(tipoviaje);
		
	}

	@Override
	@Transactional
	public TipoViaje actualizar(TipoViaje tipoviaje) {
		return tipoviajeRepository.save(tipoviaje);
	}

	
	@Override
	@Transactional
	public void eliminar(int id) {	
		tipoviajeRepository.deleteById(id);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public TipoViaje obtenerPorId(int id) {		
		return tipoviajeRepository.findById(id).get();
	}

}
