package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Reserva;

public interface ReservaService {
	public List<Reserva> listarReserva();
	public Reserva grabarReser(Reserva obj);
	public Reserva actualizarReser(Reserva obj);
	public void eliminarReser(int id);
	public Reserva buscarReser(int id);
}
