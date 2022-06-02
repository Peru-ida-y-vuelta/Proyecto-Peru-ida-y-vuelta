package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Chofer;

public interface ChoferService {
	
	public List<Chofer> listarChofer();
	public Chofer guardar(Chofer chofer);
	public Chofer actualizar(Chofer chofer);
	public void eliminar(int id);
	public Chofer buscarChofer(int id);
}
