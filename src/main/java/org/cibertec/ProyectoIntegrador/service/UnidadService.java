package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Unidad;

public interface UnidadService {

	
	public List<Unidad> listarUnidad();
	public Unidad grabarUni(Unidad obj);
	public Unidad actualizarUni(Unidad obj);
	public void eliminarUni(int id);
	public Unidad buscarUni(int id);
	public Unidad validaPlaca(String placa);
}
