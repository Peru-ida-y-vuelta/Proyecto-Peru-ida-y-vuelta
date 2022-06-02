package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Unidades;

public interface UnidadService {

	
	public List<Unidades> listarUnidad();
	public Unidades grabarUni(Unidades uni);
	public Unidades actualizarUni(Unidades uni);
	public void eliminarUni(int id);
	public Unidades buscarUni(int id);
}
