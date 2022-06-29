package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;
import org.cibertec.ProyectoIntegrador.repository.TipoViajeRepository;
import org.cibertec.ProyectoIntegrador.service.TipoViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoViajeServiceImpI implements TipoViajeService{
	
	@Autowired
	private TipoViajeRepository tipoviajeRepo;

	@Override
	public List<TipoViaje> listarTipoViaje() {
		
		return tipoviajeRepo.findAll();
		
	}

	@Override
	public TipoViaje grabar(TipoViaje tipoviaje) {
		
		return tipoviajeRepo.save(tipoviaje);
		
	}

	@Override
	public TipoViaje actualizar(TipoViaje tipoviaje) {
		return tipoviajeRepo.save(tipoviaje);
	}

	@Override
	public void eliminar(int id) {
	
		tipoviajeRepo.deleteById(id);
	}

	@Override
	public TipoViaje buscarTipoViaje(int id) {
		
		return tipoviajeRepo.findById(id).get();
		
	}

}
