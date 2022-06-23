package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Reserva;
import org.cibertec.ProyectoIntegrador.entidades.Unidad;
import org.cibertec.ProyectoIntegrador.repository.ReservaRepository;
import org.cibertec.ProyectoIntegrador.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaRepository reserRepo;

	@Override
	public List<Reserva> listarReserva() {
		
		return reserRepo.findAll();	
	}

	@Override
	public Reserva grabarReser(Reserva obj) {
		
		return reserRepo.save(obj);
	}

	@Override
	public Reserva actualizarReser(Reserva obj) {
		
		return reserRepo.save(obj);
	}

	@Override
	public void eliminarReser(int id) {
		
		reserRepo.deleteById(id);
		
	}
	
	@Override
	public Reserva buscarReser(int id) {
		return reserRepo.findById(id).orElse(null);
	}
	
}