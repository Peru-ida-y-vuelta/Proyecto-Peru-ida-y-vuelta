package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Soporte;

public interface SoporteService {

	public List<Soporte> listarSoporte();

	public Soporte Insertar(Soporte spt);

	public Soporte Actualizar(Soporte spt);

	public void eliminar(int id);

	public Soporte buscaSoporte(int id);

}
