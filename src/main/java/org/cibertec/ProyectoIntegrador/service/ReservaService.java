package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Reserva;

public interface ReservaService {
	 /////	
	List<Reserva> listarReservas(); 

	 Reserva registrar(Reserva reserva);

	 Reserva actualizar(Reserva reserva);

	 Reserva obtenerPorId(int id);

	 void eliminar(int id);
}
