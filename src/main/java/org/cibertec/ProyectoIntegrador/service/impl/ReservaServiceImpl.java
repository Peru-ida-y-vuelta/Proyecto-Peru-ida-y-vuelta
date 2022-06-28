package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Reserva;
import org.cibertec.ProyectoIntegrador.repository.ReservaRepository;
import org.cibertec.ProyectoIntegrador.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> listarReservas() {
		
		return  (List<Reserva>) reservaRepository.findAll();	
	}

	@Override
	@Transactional
	public Reserva registrar(Reserva reserva) {	
		return reservaRepository.save(reserva);
	}

	@Override
	@Transactional
	public Reserva actualizar(Reserva reserva) {	
		return reservaRepository.save(reserva);
	}

	@Override
	@Transactional
	public void eliminar(int id) {		
		reservaRepository.deleteById(id);
		
	}
	
	@Override
	 @Transactional(readOnly = true)
	public Reserva obtenerPorId(int id) {
		return reservaRepository.findById(id).get();
	}
	
}